package fr.paris.lutece.plugins.geocode.v1.web.rs.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect( creatorVisibility = Visibility.NONE, fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE )
public class Country implements Serializable
{
    private static final long serialVersionUID = 1L;

    // Variables declarations 
    private int _nId;
    
    public static final String ATTR_CODE = "code";
    public static final String ATTR_LABEL = "value";
    
    private String _strCode;
    
    private String _strValue;
    
    private Date _dateLastUpdate;

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
    @JsonProperty( ATTR_LABEL )
    public String getValue( )
    {
        return _strValue;
    }

    /**
     * Sets the Value
     * @param strValue The Value
     */ 
    @JsonProperty( ATTR_LABEL )
    public void setValue( String strValue )
    {
        _strValue = strValue;
    }
    
    /**
     * Returns the dateLastUpdate
     * @return The dateLastUpdate
     */
	public Date getDateLastUpdate() {
		return _dateLastUpdate;
	}

	/**
     * Sets the dateLastUpdate
     * @param dateLastUpdate The dateLastUpdate
     */
	public void setDateLastUpdate(Date dateLastUpdate) {
		this._dateLastUpdate = dateLastUpdate;
	}
    
}

