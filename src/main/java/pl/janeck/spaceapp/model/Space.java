package pl.janeck.spaceapp.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * ... comment class...
 *
 * @author JKN janeck@protonmail.com
 * @since 29 December 2020 @ 20:47
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "copyright",
        "date",
        "explanation",
        "hdurl",
        "media_type",
        "service_version",
        "title",
        "url"
})


public class Space {


    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("date")
    private String date;
    @JsonProperty("explanation")
    private String explanation;
    @JsonProperty("hdurl")
    private String hdurl;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    @JsonProperty("thumbnail_url")
    private String thumbnail_url;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Space(String copyright, String date, String explanation, String title, String url, Map<String, Object> additionalProperties) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.title = title;
        this.url = url;
        this.additionalProperties = additionalProperties;
    }


    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("explanation")
    public String getExplanation() {
        return explanation;
    }

    @JsonProperty("explanation")
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @JsonProperty("hdurl")
    public String getHdurl() {
        return hdurl;
    }

    @JsonProperty("hdurl")
    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    @JsonProperty("media_type")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("media_type")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonProperty("service_version")
    public String getServiceVersion() {
        return serviceVersion;
    }

    @JsonProperty("service_version")
    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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