package pl.com.mazniak.swieta2020;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "localName",
        "name",
        "countryCode",
        "fixed",
        "global",
        "counties",
        "launchYear",
        "type"
})
public class Holiday {

    @JsonProperty("date")
    private String date;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("fixed")
    private Boolean fixed;
    @JsonProperty("global")
    private Boolean global;
    @JsonProperty("counties")
    private Object counties;
    @JsonProperty("launchYear")
    private Object launchYear;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("localName")
    public String getLocalName() {
        return localName;
    }

    @JsonProperty("localName")
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("fixed")
    public Boolean getFixed() {
        return fixed;
    }

    @JsonProperty("fixed")
    public void setFixed(Boolean fixed) {
        this.fixed = fixed;
    }

    @JsonProperty("global")
    public Boolean getGlobal() {
        return global;
    }

    @JsonProperty("global")
    public void setGlobal(Boolean global) {
        this.global = global;
    }

    @JsonProperty("counties")
    public Object getCounties() {
        return counties;
    }

    @JsonProperty("counties")
    public void setCounties(Object counties) {
        this.counties = counties;
    }

    @JsonProperty("launchYear")
    public Object getLaunchYear() {
        return launchYear;
    }

    @JsonProperty("launchYear")
    public void setLaunchYear(Object launchYear) {
        this.launchYear = launchYear;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}