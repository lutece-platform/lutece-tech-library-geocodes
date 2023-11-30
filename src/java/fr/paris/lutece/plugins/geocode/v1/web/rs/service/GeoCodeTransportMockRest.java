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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IdentityQualityRestClientService
 */
public class GeoCodeTransportMockRest implements IGeoCodeTransportProvider
{

    /**
     * Logger
     */
    private static Logger _logger = Logger.getLogger( GeoCodeTransportMockRest.class );

    /** URL for identityStore Quality REST service */
    private String _strIdentityStoreQualityEndPoint;


    /**
     * {@inheritDoc }
     */
    @Override
    public City getCityByCodeAndDate( final String strCityCode, final Date dateRef )
    {
        _logger.debug( "Get City of " + strCityCode );
        final Map<String, String> mapParams = new HashMap<>( );
        mapParams.put( Constants.PARAM_DATE_VALIDITY, dateRef.toString( ) );
        
        City citymock = new City( );
        if ( strCityCode.equals( "01165" ) )
        {
	        citymock.setCode("01165");
	        citymock.setValue("Francheleins");
	        citymock.setValueMin("Francheleins");
	        citymock.setValueMinComplete("Francheleins");
	        citymock.setCodeZone("01");
        }
        return citymock;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<City> getListCitesByNameAndDate( final String strCityName, final Date dateRef )
    {
        _logger.debug( "Get list City of name " + strCityName );
        
        List<City> lstCities = new ArrayList<>( );
        
        if ( strCityName.equals( "Toulon" ) )
        {
	        City citymock = new City( );
	        citymock.setCode("83137");
	        citymock.setValue("Toulon");
	        citymock.setValueMin("Toulon");
	        citymock.setValueMinComplete("Toulon");
	        citymock.setCodeZone("83");
	        
	        lstCities.add( citymock );
        }
        
        return lstCities;
        
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public List<City> getListCitesByNameAndDateLike( final String strCityName, final Date dateRef )
    {
    	List<City> lstCities = new ArrayList<>( );
        
    	if ( strCityName.startsWith( "Tou" ) )
        {
	        City citymock = new City( );
	        citymock.setCode("83137");
	        citymock.setValue("Toulon");
	        citymock.setValueMin("Toulon");
	        citymock.setValueMinComplete("Toulon");
	        citymock.setCodeZone("83");
	        
	        City citymock2 = new City( );
	        citymock2.setCode("12281");
	        citymock2.setValue("Toulonjac");
	        citymock2.setValueMin("Toulonjac");
	        citymock2.setValueMinComplete("Toulonjac");
	        citymock2.setCodeZone("12");
	        
	        lstCities.add( citymock );
	        lstCities.add( citymock2 );
        }
        
        return lstCities;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Country getCountryByCodeAndDate( final String strCountryCode, final Date dateRef )
    {
        
        Country countrymock = new Country( );
        if ( strCountryCode.equals( "99139" ) )
        {
	        countrymock.setCode("99139");
	        countrymock.setValue("PORTUGAL");
        }
        return countrymock;
    }
    
    /**
     * {@inheritDoc }
     */
    public Country getCountryByNameAndDate( final String strCountryName, final Date dateRef )
    {
        
        Country countrymock = new Country( );
        if ( strCountryName.startsWith( "FRA" ) )
        {
		    countrymock.setCode("99100");
		    countrymock.setValue("FRANCE");
        }
        return countrymock;
    }
}
