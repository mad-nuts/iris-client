/*
 * SORMAS REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.55.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package de.healthIMIS.sormas.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.healthIMIS.sormas.client.model.CommunityReferenceDto;
import de.healthIMIS.sormas.client.model.DistrictReferenceDto;
import de.healthIMIS.sormas.client.model.FacilityReferenceDto;
import de.healthIMIS.sormas.client.model.RegionReferenceDto;
import de.healthIMIS.sormas.client.model.YesNoUnknown;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.time.Instant;
/**
 * PreviousHospitalizationDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-28T11:46:54.705673+01:00[Europe/Berlin]")
public class PreviousHospitalizationDto {
  @JsonProperty("creationDate")
  private Instant creationDate = null;

  @JsonProperty("changeDate")
  private Instant changeDate = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("pseudonymized")
  private Boolean pseudonymized = null;

  @JsonProperty("admissionDate")
  private Instant admissionDate = null;

  @JsonProperty("dischargeDate")
  private Instant dischargeDate = null;

  @JsonProperty("region")
  private RegionReferenceDto region = null;

  @JsonProperty("district")
  private DistrictReferenceDto district = null;

  @JsonProperty("community")
  private CommunityReferenceDto community = null;

  @JsonProperty("healthFacility")
  private FacilityReferenceDto healthFacility = null;

  @JsonProperty("healthFacilityDetails")
  private String healthFacilityDetails = null;

  @JsonProperty("isolated")
  private YesNoUnknown isolated = null;

  @JsonProperty("description")
  private String description = null;

  public PreviousHospitalizationDto creationDate(Instant creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @Schema(description = "")
  public Instant getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Instant creationDate) {
    this.creationDate = creationDate;
  }

  public PreviousHospitalizationDto changeDate(Instant changeDate) {
    this.changeDate = changeDate;
    return this;
  }

   /**
   * Get changeDate
   * @return changeDate
  **/
  @Schema(description = "")
  public Instant getChangeDate() {
    return changeDate;
  }

  public void setChangeDate(Instant changeDate) {
    this.changeDate = changeDate;
  }

  public PreviousHospitalizationDto uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @Schema(description = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public PreviousHospitalizationDto pseudonymized(Boolean pseudonymized) {
    this.pseudonymized = pseudonymized;
    return this;
  }

   /**
   * Get pseudonymized
   * @return pseudonymized
  **/
  @Schema(description = "")
  public Boolean isPseudonymized() {
    return pseudonymized;
  }

  public void setPseudonymized(Boolean pseudonymized) {
    this.pseudonymized = pseudonymized;
  }

  public PreviousHospitalizationDto admissionDate(Instant admissionDate) {
    this.admissionDate = admissionDate;
    return this;
  }

   /**
   * Get admissionDate
   * @return admissionDate
  **/
  @Schema(description = "")
  public Instant getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(Instant admissionDate) {
    this.admissionDate = admissionDate;
  }

  public PreviousHospitalizationDto dischargeDate(Instant dischargeDate) {
    this.dischargeDate = dischargeDate;
    return this;
  }

   /**
   * Get dischargeDate
   * @return dischargeDate
  **/
  @Schema(description = "")
  public Instant getDischargeDate() {
    return dischargeDate;
  }

  public void setDischargeDate(Instant dischargeDate) {
    this.dischargeDate = dischargeDate;
  }

  public PreviousHospitalizationDto region(RegionReferenceDto region) {
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @Schema(description = "")
  public RegionReferenceDto getRegion() {
    return region;
  }

  public void setRegion(RegionReferenceDto region) {
    this.region = region;
  }

  public PreviousHospitalizationDto district(DistrictReferenceDto district) {
    this.district = district;
    return this;
  }

   /**
   * Get district
   * @return district
  **/
  @Schema(description = "")
  public DistrictReferenceDto getDistrict() {
    return district;
  }

  public void setDistrict(DistrictReferenceDto district) {
    this.district = district;
  }

  public PreviousHospitalizationDto community(CommunityReferenceDto community) {
    this.community = community;
    return this;
  }

   /**
   * Get community
   * @return community
  **/
  @Schema(description = "")
  public CommunityReferenceDto getCommunity() {
    return community;
  }

  public void setCommunity(CommunityReferenceDto community) {
    this.community = community;
  }

  public PreviousHospitalizationDto healthFacility(FacilityReferenceDto healthFacility) {
    this.healthFacility = healthFacility;
    return this;
  }

   /**
   * Get healthFacility
   * @return healthFacility
  **/
  @Schema(description = "")
  public FacilityReferenceDto getHealthFacility() {
    return healthFacility;
  }

  public void setHealthFacility(FacilityReferenceDto healthFacility) {
    this.healthFacility = healthFacility;
  }

  public PreviousHospitalizationDto healthFacilityDetails(String healthFacilityDetails) {
    this.healthFacilityDetails = healthFacilityDetails;
    return this;
  }

   /**
   * Get healthFacilityDetails
   * @return healthFacilityDetails
  **/
  @Schema(description = "")
  public String getHealthFacilityDetails() {
    return healthFacilityDetails;
  }

  public void setHealthFacilityDetails(String healthFacilityDetails) {
    this.healthFacilityDetails = healthFacilityDetails;
  }

  public PreviousHospitalizationDto isolated(YesNoUnknown isolated) {
    this.isolated = isolated;
    return this;
  }

   /**
   * Get isolated
   * @return isolated
  **/
  @Schema(description = "")
  public YesNoUnknown getIsolated() {
    return isolated;
  }

  public void setIsolated(YesNoUnknown isolated) {
    this.isolated = isolated;
  }

  public PreviousHospitalizationDto description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @Schema(description = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PreviousHospitalizationDto previousHospitalizationDto = (PreviousHospitalizationDto) o;
    return Objects.equals(this.creationDate, previousHospitalizationDto.creationDate) &&
        Objects.equals(this.changeDate, previousHospitalizationDto.changeDate) &&
        Objects.equals(this.uuid, previousHospitalizationDto.uuid) &&
        Objects.equals(this.pseudonymized, previousHospitalizationDto.pseudonymized) &&
        Objects.equals(this.admissionDate, previousHospitalizationDto.admissionDate) &&
        Objects.equals(this.dischargeDate, previousHospitalizationDto.dischargeDate) &&
        Objects.equals(this.region, previousHospitalizationDto.region) &&
        Objects.equals(this.district, previousHospitalizationDto.district) &&
        Objects.equals(this.community, previousHospitalizationDto.community) &&
        Objects.equals(this.healthFacility, previousHospitalizationDto.healthFacility) &&
        Objects.equals(this.healthFacilityDetails, previousHospitalizationDto.healthFacilityDetails) &&
        Objects.equals(this.isolated, previousHospitalizationDto.isolated) &&
        Objects.equals(this.description, previousHospitalizationDto.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, changeDate, uuid, pseudonymized, admissionDate, dischargeDate, region, district, community, healthFacility, healthFacilityDetails, isolated, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreviousHospitalizationDto {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    pseudonymized: ").append(toIndentedString(pseudonymized)).append("\n");
    sb.append("    admissionDate: ").append(toIndentedString(admissionDate)).append("\n");
    sb.append("    dischargeDate: ").append(toIndentedString(dischargeDate)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    district: ").append(toIndentedString(district)).append("\n");
    sb.append("    community: ").append(toIndentedString(community)).append("\n");
    sb.append("    healthFacility: ").append(toIndentedString(healthFacility)).append("\n");
    sb.append("    healthFacilityDetails: ").append(toIndentedString(healthFacilityDetails)).append("\n");
    sb.append("    isolated: ").append(toIndentedString(isolated)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
