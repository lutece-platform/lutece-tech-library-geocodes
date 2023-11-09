/*
 * Copyright (c) 2002-2023, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.geocode.v1.web.rs.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.paris.lutece.plugins.geocode.v1.web.rs.util.Constants;
import fr.paris.lutece.plugins.geocode.v1.web.service.CustomResponseStatusValidator;
import fr.paris.lutece.plugins.geocode.v1.web.service.IHttpTransportProvider;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.InvalidResponseStatus;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * IHttpTransportProvider which use library-httpaccess
 */
public class HttpAccessTransport implements IHttpTransportProvider
{
    private static Logger _logger = Logger.getLogger( HttpAccessTransport.class );

    protected HttpAccess _httpClient;
    protected String _strEndPoint;

    public HttpAccessTransport( )
    {
        this._httpClient = new HttpAccess( CustomResponseStatusValidator.getInstance( ) );
    }
    
    @Override
    public <T> T doGet(String strEndPointUrl, Map<String, String> mapParams, Map<String, String> mapHeadersRequest,
    		Class<T> responseJsonClass, ObjectMapper mapper) throws Exception
    {
        String strResponseJSON = "";
        T oResponse = null;
        
        try
        {
            URIBuilder uriBuilder = new URIBuilder( strEndPointUrl );

            if ( ( mapParams != null ) && !mapParams.isEmpty( ) )
            {
                for ( String strParamKey : mapParams.keySet( ) )
                {
                    uriBuilder.addParameter( strParamKey, mapParams.get( strParamKey ) );
                }
            }

            addAuthentication( mapHeadersRequest );
            strResponseJSON = this._httpClient.doGet( uriBuilder.toString( ), null, null, mapHeadersRequest );
            oResponse = mapJson( mapper, strResponseJSON, responseJsonClass );
        }
        catch( Exception e )
        {
        	handleExceptionGeocode( e );
        }

        return oResponse;
    }
    
    @Override
    public <T> List<T> doGetList(String strEndPointUrl, Map<String, String> mapParams, Map<String, String> mapHeadersRequest,
    		Class<T> responseJsonClass, ObjectMapper mapper) throws Exception
    {
        String strResponseJSON = "";
        List<T> oResponse = null;
        
        try
        {
            URIBuilder uriBuilder = new URIBuilder( strEndPointUrl );

            if ( ( mapParams != null ) && !mapParams.isEmpty( ) )
            {
                for ( String strParamKey : mapParams.keySet( ) )
                {
                    uriBuilder.addParameter( strParamKey, mapParams.get( strParamKey ) );
                }
            }

            addAuthentication( mapHeadersRequest );
            strResponseJSON = this._httpClient.doGet( uriBuilder.toString( ), null, null, mapHeadersRequest );
            oResponse = mapJsonList( mapper, strResponseJSON, responseJsonClass );
        }
        catch( Exception e )
        {
        	handleExceptionGeocode( e );
        }

        return oResponse;
    }
    
    /**
     * add error log and throw correct Exception depending on the specified Exception
     * 
     * @param e
     *            root exception
     * @throws IdentityNotFoundException
     *             if the specified Exception is an HttpAccessException with HTTP code 404
     * @throws IdentityStoreException
     *             otherwise
     */
    protected void handleExceptionGeocode( Exception e ) throws Exception
    {
        String strError = "LibraryIdentityStore - Error HttpAccessTransport :";
        _logger.error( strError + e.getMessage( ), e );

        if ( e instanceof InvalidResponseStatus && HttpStatus.SC_NOT_FOUND == ( (InvalidResponseStatus) e ).getResponseStatus( )
                || e instanceof Exception )
        {
            // throw new IdentityNotFoundException( strError, e );
            throw new Exception( strError, e );
        }
        else
        {
            throw new Exception( strError, e );
        }
    }

    /**
     * add specific authentication to request
     * 
     * @param mapHeadersRequest
     *            map of headers to add
     * @throws IdentityStoreException
     */
    protected void addAuthentication( Map<String, String> mapHeadersRequest ) throws Exception
    {
        // default : no authentication
    }

    /**
     * set end point
     * 
     * @param strApiEndPointUrl
     */
    public void setApiEndPointUrl( String strApiEndPointUrl )
    {

        _strEndPoint = strApiEndPointUrl;
    }

    /**
     * get end point
     * 
     * @return strEndPointUrl
     */
    public String getApiEndPointUrl( )
    {

        return _strEndPoint;
    }

    /**
     * Converts json String response to the desired {@link ResponseDto} subclass instance.
     *
     * @param mapper
     *            the mapper
     * @param jsonStr
     *            the json string value
     * @param responseClass
     *            the desired {@link ResponseDto} subclass
     * @return the desired {@link ResponseDto} subclass instance
     */
    private <T> T mapJson( final ObjectMapper mapper, final String jsonStr, final Class<T> responseClass )
            throws JsonProcessingException, InstantiationException, IllegalAccessException
    {
        T response = null;
        try
        {
        	JsonNode root = mapper.readTree( jsonStr );
        	JsonNode rootResult = root.get( Constants.PARAM_RESULT );
        	String strResult = rootResult.toPrettyString( );
            response = mapper.readValue( strResult, responseClass );
        }
        catch( final Exception e )
        {
        	String strError = "API GEOCODE - Error converting to Object from JSON '" + jsonStr + "' : ";
            _logger.error( strError + e.getMessage( ), e );
        }
        return response;
    }

    /**
     * Converts json String response to a {@link List} of the desired {@link ResponseDto} subclass instances.
     *
     * @param mapper
     *            the mapper
     * @param jsonStr
     *            the json string value
     * @param responseClass
     *            the desired {@link ResponseDto} subclass
     * @return a {@link List} of the desired {@link ResponseDto} subclass instances
     */
    private <T> List<T> mapJsonList( final ObjectMapper mapper, final String jsonStr, final Class<T> responseClass )
            throws JsonProcessingException, InstantiationException, IllegalAccessException
    {
        List<T> responseList = new ArrayList<>( );
        JavaType responseListClassType = mapper.getTypeFactory( ).constructCollectionType( List.class, responseClass );
        try
        {
        	JsonNode root = mapper.readTree( jsonStr );
        	JsonNode rootResult = root.get( Constants.PARAM_RESULT );
        	String strResult = rootResult.toPrettyString( );
            responseList = mapper.readValue( strResult, responseListClassType );
        }
        catch( final Exception e1 )
        {
            try
            {
                // If mapper didn't manage to map the json with the desired class, we try to map it as a list of error response
                //responseListClassType = mapper.getTypeFactory( ).constructCollectionType( List.class, ErrorResponse.class );
                String strError = "API GEOCODE - Error converting to Object from JSON '" + jsonStr + "' : ";
                _logger.error( strError + e1.getMessage( ), e1 );
            }
            catch( final Exception e2 )
            {
            	String strError = "API GEOCODE - Error converting to Object from JSON '" + jsonStr + "' : ";
                _logger.error( strError + e2.getMessage( ), e2 );
            }
        }
        return responseList;
    }

}
