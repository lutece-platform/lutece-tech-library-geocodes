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
package fr.paris.lutece.plugins.geocode.v1.web.service;

import java.util.Date;
import java.util.List;

import fr.paris.lutece.plugins.geocode.v1.web.rs.dto.City;
import fr.paris.lutece.plugins.geocode.v1.web.rs.dto.Country;

/**
 * Service regarding identity quality.
 */
public class GeoCodeService
{

    /** transport provider */
    private IGeoCodeTransportProvider _transportProvider;

    /**
     * Simple Constructor
     */
    public GeoCodeService( )
    {
        super( );
    }

    /**
     * Constructor with IIdentityTransportProvider in parameters
     *
     * @param transportProvider
     *            IIdentityQualityTransportProvider
     */
    public GeoCodeService( final IGeoCodeTransportProvider transportProvider )
    {
        super( );
        this._transportProvider = transportProvider;
    }

    /**
     * setter of transportProvider parameter
     *
     * @param transportProvider
     *            IIdentityQualityTransportProvider
     */
    public void setTransportProvider( final IGeoCodeTransportProvider transportProvider )
    {
        this._transportProvider = transportProvider;
    }
    
    /**
     * Get the city informations from a code INSEE and a validity date
     * 
     * @param strCodeCity
     *            the code INSEE of the city
     * @param dateRef
     *            the date validity
     * @return a city information {@link IdentityDto}
     */
    public City getCityByCodeAndDate( final String strCodeCity, Date dateRef )
            throws Exception
    {
        return this._transportProvider.getCityByCodeAndDate( strCodeCity, dateRef );
    }
    
    /**
     * Get the list of cities from an exact name and a validity date
     * 
     * @param strNameCity
     *            the name of the city
     * @param dateRef
     *            the date validity
     * @return a list of cities  {@link IdentityDto}
     */
    public List<City> getListCitiesByNameAndDate( final String strNameCity, Date dateRef )
            throws Exception
    {
        return this._transportProvider.getListCitesByNameAndDate( strNameCity, dateRef );
    }
    
    /**
     * Get the list of cities from a name and a validity date
     * 
     * @param strNameCity
     *            the name of the city
     * @param dateRef
     *            the date validity
     * @return a list of cities  {@link IdentityDto}
     */
    public List<City> getListCitiesByNameAndDateLike( final String strNameCity, Date dateRef )
            throws Exception
    {
        return this._transportProvider.getListCitesByNameAndDateLike( strNameCity, dateRef );
    }
    
    /**
     * Get a list of country from name and date
     * @param strNameCountry
     * @param dateRef
     * @return
     * @throws Exception
     */
    public List<Country> getListCountryByNameAndDate( final String strNameCountry, Date dateRef )
    		throws Exception
    {
    	return this._transportProvider.getListCountriesByNameAndDate( strNameCountry, dateRef );
    }
    
    /**
     * Get a country for a code and a name
     * @param strCodeCountry
     * @param dateRef
     * @return
     * @throws Exception
     */
    public Country getCountryByCodeAndDate( final String strCodeCountry, Date dateRef )
    		throws Exception
    {
    	return this._transportProvider.getCountryByCodeAndDate( strCodeCountry, dateRef );
    }

}
