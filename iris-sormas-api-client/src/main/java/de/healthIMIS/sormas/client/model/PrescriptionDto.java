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
import de.healthIMIS.sormas.client.model.TherapyReferenceDto;
import de.healthIMIS.sormas.client.model.TreatmentRoute;
import de.healthIMIS.sormas.client.model.TreatmentType;
import de.healthIMIS.sormas.client.model.TypeOfDrug;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.time.Instant;
/**
 * PrescriptionDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-28T11:46:54.705673+01:00[Europe/Berlin]")
public class PrescriptionDto {
  @JsonProperty("creationDate")
  private Instant creationDate = null;

  @JsonProperty("changeDate")
  private Instant changeDate = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("pseudonymized")
  private Boolean pseudonymized = null;

  @JsonProperty("therapy")
  private TherapyReferenceDto therapy = null;

  @JsonProperty("prescriptionDate")
  private Instant prescriptionDate = null;

  @JsonProperty("prescriptionStart")
  private Instant prescriptionStart = null;

  @JsonProperty("prescriptionEnd")
  private Instant prescriptionEnd = null;

  @JsonProperty("prescribingClinician")
  private String prescribingClinician = null;

  @JsonProperty("prescriptionType")
  private TreatmentType prescriptionType = null;

  @JsonProperty("prescriptionDetails")
  private String prescriptionDetails = null;

  @JsonProperty("typeOfDrug")
  private TypeOfDrug typeOfDrug = null;

  @JsonProperty("frequency")
  private String frequency = null;

  @JsonProperty("dose")
  private String dose = null;

  @JsonProperty("route")
  private TreatmentRoute route = null;

  @JsonProperty("routeDetails")
  private String routeDetails = null;

  @JsonProperty("additionalNotes")
  private String additionalNotes = null;

  public PrescriptionDto creationDate(Instant creationDate) {
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

  public PrescriptionDto changeDate(Instant changeDate) {
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

  public PrescriptionDto uuid(String uuid) {
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

  public PrescriptionDto pseudonymized(Boolean pseudonymized) {
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

  public PrescriptionDto therapy(TherapyReferenceDto therapy) {
    this.therapy = therapy;
    return this;
  }

   /**
   * Get therapy
   * @return therapy
  **/
  @Schema(description = "")
  public TherapyReferenceDto getTherapy() {
    return therapy;
  }

  public void setTherapy(TherapyReferenceDto therapy) {
    this.therapy = therapy;
  }

  public PrescriptionDto prescriptionDate(Instant prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
    return this;
  }

   /**
   * Get prescriptionDate
   * @return prescriptionDate
  **/
  @Schema(description = "")
  public Instant getPrescriptionDate() {
    return prescriptionDate;
  }

  public void setPrescriptionDate(Instant prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
  }

  public PrescriptionDto prescriptionStart(Instant prescriptionStart) {
    this.prescriptionStart = prescriptionStart;
    return this;
  }

   /**
   * Get prescriptionStart
   * @return prescriptionStart
  **/
  @Schema(description = "")
  public Instant getPrescriptionStart() {
    return prescriptionStart;
  }

  public void setPrescriptionStart(Instant prescriptionStart) {
    this.prescriptionStart = prescriptionStart;
  }

  public PrescriptionDto prescriptionEnd(Instant prescriptionEnd) {
    this.prescriptionEnd = prescriptionEnd;
    return this;
  }

   /**
   * Get prescriptionEnd
   * @return prescriptionEnd
  **/
  @Schema(description = "")
  public Instant getPrescriptionEnd() {
    return prescriptionEnd;
  }

  public void setPrescriptionEnd(Instant prescriptionEnd) {
    this.prescriptionEnd = prescriptionEnd;
  }

  public PrescriptionDto prescribingClinician(String prescribingClinician) {
    this.prescribingClinician = prescribingClinician;
    return this;
  }

   /**
   * Get prescribingClinician
   * @return prescribingClinician
  **/
  @Schema(description = "")
  public String getPrescribingClinician() {
    return prescribingClinician;
  }

  public void setPrescribingClinician(String prescribingClinician) {
    this.prescribingClinician = prescribingClinician;
  }

  public PrescriptionDto prescriptionType(TreatmentType prescriptionType) {
    this.prescriptionType = prescriptionType;
    return this;
  }

   /**
   * Get prescriptionType
   * @return prescriptionType
  **/
  @Schema(description = "")
  public TreatmentType getPrescriptionType() {
    return prescriptionType;
  }

  public void setPrescriptionType(TreatmentType prescriptionType) {
    this.prescriptionType = prescriptionType;
  }

  public PrescriptionDto prescriptionDetails(String prescriptionDetails) {
    this.prescriptionDetails = prescriptionDetails;
    return this;
  }

   /**
   * Get prescriptionDetails
   * @return prescriptionDetails
  **/
  @Schema(description = "")
  public String getPrescriptionDetails() {
    return prescriptionDetails;
  }

  public void setPrescriptionDetails(String prescriptionDetails) {
    this.prescriptionDetails = prescriptionDetails;
  }

  public PrescriptionDto typeOfDrug(TypeOfDrug typeOfDrug) {
    this.typeOfDrug = typeOfDrug;
    return this;
  }

   /**
   * Get typeOfDrug
   * @return typeOfDrug
  **/
  @Schema(description = "")
  public TypeOfDrug getTypeOfDrug() {
    return typeOfDrug;
  }

  public void setTypeOfDrug(TypeOfDrug typeOfDrug) {
    this.typeOfDrug = typeOfDrug;
  }

  public PrescriptionDto frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

   /**
   * Get frequency
   * @return frequency
  **/
  @Schema(description = "")
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public PrescriptionDto dose(String dose) {
    this.dose = dose;
    return this;
  }

   /**
   * Get dose
   * @return dose
  **/
  @Schema(description = "")
  public String getDose() {
    return dose;
  }

  public void setDose(String dose) {
    this.dose = dose;
  }

  public PrescriptionDto route(TreatmentRoute route) {
    this.route = route;
    return this;
  }

   /**
   * Get route
   * @return route
  **/
  @Schema(description = "")
  public TreatmentRoute getRoute() {
    return route;
  }

  public void setRoute(TreatmentRoute route) {
    this.route = route;
  }

  public PrescriptionDto routeDetails(String routeDetails) {
    this.routeDetails = routeDetails;
    return this;
  }

   /**
   * Get routeDetails
   * @return routeDetails
  **/
  @Schema(description = "")
  public String getRouteDetails() {
    return routeDetails;
  }

  public void setRouteDetails(String routeDetails) {
    this.routeDetails = routeDetails;
  }

  public PrescriptionDto additionalNotes(String additionalNotes) {
    this.additionalNotes = additionalNotes;
    return this;
  }

   /**
   * Get additionalNotes
   * @return additionalNotes
  **/
  @Schema(description = "")
  public String getAdditionalNotes() {
    return additionalNotes;
  }

  public void setAdditionalNotes(String additionalNotes) {
    this.additionalNotes = additionalNotes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrescriptionDto prescriptionDto = (PrescriptionDto) o;
    return Objects.equals(this.creationDate, prescriptionDto.creationDate) &&
        Objects.equals(this.changeDate, prescriptionDto.changeDate) &&
        Objects.equals(this.uuid, prescriptionDto.uuid) &&
        Objects.equals(this.pseudonymized, prescriptionDto.pseudonymized) &&
        Objects.equals(this.therapy, prescriptionDto.therapy) &&
        Objects.equals(this.prescriptionDate, prescriptionDto.prescriptionDate) &&
        Objects.equals(this.prescriptionStart, prescriptionDto.prescriptionStart) &&
        Objects.equals(this.prescriptionEnd, prescriptionDto.prescriptionEnd) &&
        Objects.equals(this.prescribingClinician, prescriptionDto.prescribingClinician) &&
        Objects.equals(this.prescriptionType, prescriptionDto.prescriptionType) &&
        Objects.equals(this.prescriptionDetails, prescriptionDto.prescriptionDetails) &&
        Objects.equals(this.typeOfDrug, prescriptionDto.typeOfDrug) &&
        Objects.equals(this.frequency, prescriptionDto.frequency) &&
        Objects.equals(this.dose, prescriptionDto.dose) &&
        Objects.equals(this.route, prescriptionDto.route) &&
        Objects.equals(this.routeDetails, prescriptionDto.routeDetails) &&
        Objects.equals(this.additionalNotes, prescriptionDto.additionalNotes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, changeDate, uuid, pseudonymized, therapy, prescriptionDate, prescriptionStart, prescriptionEnd, prescribingClinician, prescriptionType, prescriptionDetails, typeOfDrug, frequency, dose, route, routeDetails, additionalNotes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrescriptionDto {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    pseudonymized: ").append(toIndentedString(pseudonymized)).append("\n");
    sb.append("    therapy: ").append(toIndentedString(therapy)).append("\n");
    sb.append("    prescriptionDate: ").append(toIndentedString(prescriptionDate)).append("\n");
    sb.append("    prescriptionStart: ").append(toIndentedString(prescriptionStart)).append("\n");
    sb.append("    prescriptionEnd: ").append(toIndentedString(prescriptionEnd)).append("\n");
    sb.append("    prescribingClinician: ").append(toIndentedString(prescribingClinician)).append("\n");
    sb.append("    prescriptionType: ").append(toIndentedString(prescriptionType)).append("\n");
    sb.append("    prescriptionDetails: ").append(toIndentedString(prescriptionDetails)).append("\n");
    sb.append("    typeOfDrug: ").append(toIndentedString(typeOfDrug)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    dose: ").append(toIndentedString(dose)).append("\n");
    sb.append("    route: ").append(toIndentedString(route)).append("\n");
    sb.append("    routeDetails: ").append(toIndentedString(routeDetails)).append("\n");
    sb.append("    additionalNotes: ").append(toIndentedString(additionalNotes)).append("\n");
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
