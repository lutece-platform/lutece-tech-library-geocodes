package fr.paris.lutece.plugins.geocode.v1.web.rs.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect( creatorVisibility = Visibility.NONE, fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE )
public class City implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    public static final String ATTR_CODE = "code";
    public static final String ATTR_DATE_CREATION = "creationDate";
    public static final String ATTR_DATE_END = "endDate";
    public static final String ATTR_LABEL_WITHOUT_ARTICLE = "valueWithoutArticle";
    public static final String ATTR_LABEL = "value";
    public static final String ATTR_CODE_ZONE = "codeZone";
    public static final String ATTR_CODE_COUNTRY = "codeCountry";
    public static final String ATTR_VALUE_DISPLAY = "displayValue";
    
    private String _strCodeCountry;
    
    private String _strCode;
     
    private String _strValue;
     
    private String _strCodeZone;
    
    private Date _dateValidityStart;
    
    private Date _dateValidityEnd;
    
    private String _strValueMin;
    
    private String _strValueMinComplete;
    
    private String _strDisplayValue;

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }
    
    /**
     * Returns the CodeCountry
     * @return The CodeCountry
     */
    @JsonProperty( ATTR_CODE_COUNTRY )
    public String getCodeCountry( )
    {
        return _strCodeCountry;
    }

    /**
     * Sets the CodeCountry
     * @param strCodeCountry The CodeCountry
     */
    @JsonProperty( ATTR_CODE_COUNTRY )
    public void setCodeCountry( String strCodeCountry )
    {
        _strCodeCountry = strCodeCountry;
    }
    
    
    /**
     * Returns the Code
     * @return The Code
     */
    @JsonProperty( ATTR_CODE )
    public String getCode( )
    {
        return _strCode;
    }

    /**
     * Sets the Code
     * @param strCode The Code
     */ 
    @JsonProperty( ATTR_CODE )
    public void setCode( String strCode )
    {
        _strCode = strCode;
    }
    
    
    /**
     * Returns the Value
     * @return The Value
     */
    public String getValue( )
    {
        return _strValue;
    }

    /**
     * Sets the Value
     * @param strValue The Value
     */ 
    public void setValue( String strValue )
    {
        _strValue = strValue;
    }
    
    
    /**
     * Returns the CodeZone
     * @return The CodeZone
     */
    @JsonProperty( ATTR_CODE_ZONE )
    public String getCodeZone( )
    {
        return _strCodeZone;
    }

    /**
     * Sets the CodeZone
     * @param strCodeZone The CodeZone
     */
    @JsonProperty( ATTR_CODE_ZONE )
    public void setCodeZone( String strCodeZone )
    {
        _strCodeZone = strCodeZone;
    }

    /**
     * Returns the dateValidityStart
     * @return The dateValidityStart
     */
	public Date getDateValidityStart( ) {
		return _dateValidityStart;
	}
    
	/**
     * Returns the dateValidityStart
     * @return The dateValidityStart
     */
	@JsonProperty( ATTR_DATE_CREATION )
    public String getDateValidityStartToString( ) {
		return _dateValidityStart.toString( );
	}


	/**
     * Sets the dateValidityStart
     * @param dateValidityStart The dateValidityStart
     */ 
    @JsonProperty( ATTR_DATE_CREATION )
	public void setDateValidityStart(Date dateValidityStart) {
		this._dateValidityStart = dateValidityStart;
	}

	/**
     * Returns the dateValidityEnd
     * @return The dateValidityEnd
     */
	public Date getDateValidityEnd() {
		return _dateValidityEnd;
	}
    
    /**
     * Returns the dateValidityStart
     * @return The dateValidityStart
     */
	@JsonProperty( ATTR_DATE_END )
    public String getDateValidityEndToString( ) {
		return _dateValidityEnd.toString( );
	}

	/**
     * Sets the dateValidityEnd
     * @param dateValidityEnd The dateValidityEnd
     */ 
    @JsonProperty( ATTR_DATE_END )
	public void setDateValidityEnd( Date dateValidityEnd ) {
		this._dateValidityEnd = dateValidityEnd;
	}

	/**
     * Returns the ValueMin
     * @return The ValueMin
     */
	@JsonProperty( ATTR_LABEL_WITHOUT_ARTICLE )
	public String getValueMin( ) {
		return _strValueMin;
	}

	/**
     * Sets the strValueMin
     * @param strValueMin The strValueMin
     */
	@JsonProperty( ATTR_LABEL_WITHOUT_ARTICLE )
	public void setValueMin( String strValueMin ) {
		this._strValueMin = strValueMin;
	}

	/**
     * Returns the ValueMinComplete
     * @return The ValueMinComplete
     */
	@JsonProperty( ATTR_LABEL )
	public String getValueMinComplete( ) {
		return _strValueMinComplete;
	}

	/**
     * Sets the strValueMinComplete
     * @param strValueMinComplete The strValueMinComplete
     */
	@JsonProperty( ATTR_LABEL )
	public void setValueMinComplete( String strValueMinComplete ) {
		this._strValueMinComplete = strValueMinComplete;
	}

	/**
     * Returns the DisplayValue
     * @return The DisplayValue
     */
	@JsonProperty( ATTR_VALUE_DISPLAY )
	public String getDisplayValue() {
		return _strDisplayValue;
	}

	/**
     * Sets the _strDisplayValue
     * @param strDisplayValue The strDisplayValue
     */
	@JsonProperty( ATTR_VALUE_DISPLAY )
	public void setDisplayValue(String strDisplayValue) {
		this._strDisplayValue = strDisplayValue;
	}
    
}

