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

import fr.paris.lutece.plugins.geocode.v1.web.rs.dto.City;
import fr.paris.lutece.plugins.geocode.v1.web.rs.dto.Country;
import fr.paris.lutece.plugins.geocode.v1.web.rs.util.Constants;
import fr.paris.lutece.plugins.geocode.v1.web.service.IGeoCodeTransportProvider;
import fr.paris.lutece.plugins.geocode.v1.web.service.IHttpTransportProvider;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IdentityQualityRestClientService
 */
public class GeoCodeTransportRest extends AbstractTransportRest implements IGeoCodeTransportProvider
{

    /**
     * Logger
     */
    private static Logger _logger = Logger.getLogger( GeoCodeTransportRest.class );

    /** URL for identityStore Quality REST service */
    private String _strIdentityStoreQualityEndPoint;

    /**
     * Simple Constructor
     */
    public GeoCodeTransportRest( )
    {
        super( new HttpAccessTransport( ) );
    }

    /**
     * Constructor with IHttpTransportProvider parameter
     *
     * @param httpTransport
     *            the provider to use
     */
    public GeoCodeTransportRest( final IHttpTransportProvider httpTransport )
    {
        super( httpTransport );

        _strIdentityStoreQualityEndPoint = httpTransport.getApiEndPointUrl( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public City getCityByCodeAndDate( final String strCityCode, final Date dateRef ) throws Exception
    {
        _logger.debug( "Get City of " + strCityCode );
        final Map<String, String> mapParams = new HashMap<>( );
        mapParams.put( Constants.PARAM_DATE_VALIDITY, dateRef.toString( ) );

        //final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.QUALITY_PATH + "/" + Constants.RULES_PATH;
        final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.CITIES_PATH + "/" + strCityCode;
        return _httpTransport.doGet( url, mapParams,null,  City.class, _mapper );
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<City> getListCitesByNameAndDate( final String strCityName, final Date dateRef ) throws Exception
    {
        _logger.debug( "Get list City of name " + strCityName );
        final Map<String, String> mapParams = new HashMap<>( );
        mapParams.put( Constants.PARAM_SEARCH_NAME_CITY, strCityName );
        mapParams.put( Constants.PARAM_DATE_VALIDITY, dateRef.toString( ) );

        //final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.QUALITY_PATH + "/" + Constants.RULES_PATH;
        final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.CITIES_PATH;
        return _httpTransport.doGetList( url, mapParams,null,  City.class, _mapper );
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<City> getListCitesByNameAndDateLike( final String strCityName, final Date dateRef ) throws Exception
    {
        _logger.debug( "Get list like City of name " + strCityName );
        final Map<String, String> mapParams = new HashMap<>( );
        mapParams.put( Constants.PARAM_SEARCH_NAME_CITY, strCityName );
        mapParams.put( Constants.PARAM_DATE_VALIDITY, dateRef.toString( ) );

        final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.CITIES_PATH + Constants.LIST_PATH;
        return _httpTransport.doGetList( url, mapParams,null,  City.class, _mapper );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Country getCountryByCodeAndDate( final String strCountryCode, final Date dateRef ) throws Exception
    {
        _logger.debug( "Get Country of " + strCountryCode );
        final Map<String, String> mapParams = new HashMap<>( );
        mapParams.put( Constants.PARAM_DATE_VALIDITY, dateRef.toString( ) );

        //final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.QUALITY_PATH + "/" + Constants.RULES_PATH;
        final String url = _strIdentityStoreQualityEndPoint + Constants.VERSION_PATH_V1 + Constants.COUNTRIES_PATH + "/" + strCountryCode;
        return _httpTransport.doGet( url, mapParams,null,  Country.class, _mapper );
    }
}
