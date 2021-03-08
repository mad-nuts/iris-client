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
import de.healthIMIS.sormas.client.model.AdditionalTestType;
import de.healthIMIS.sormas.client.model.CaseReferenceDto;
import de.healthIMIS.sormas.client.model.ContactReferenceDto;
import de.healthIMIS.sormas.client.model.EventParticipantReferenceDto;
import de.healthIMIS.sormas.client.model.FacilityReferenceDto;
import de.healthIMIS.sormas.client.model.PathogenTestResultType;
import de.healthIMIS.sormas.client.model.PathogenTestType;
import de.healthIMIS.sormas.client.model.SampleMaterial;
import de.healthIMIS.sormas.client.model.SamplePurpose;
import de.healthIMIS.sormas.client.model.SampleReferenceDto;
import de.healthIMIS.sormas.client.model.SampleSource;
import de.healthIMIS.sormas.client.model.SormasToSormasOriginInfoDto;
import de.healthIMIS.sormas.client.model.SpecimenCondition;
import de.healthIMIS.sormas.client.model.UserReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
/**
 * SampleDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-28T11:46:54.705673+01:00[Europe/Berlin]")
public class SampleDto {
  @JsonProperty("creationDate")
  private Instant creationDate = null;

  @JsonProperty("changeDate")
  private Instant changeDate = null;

  @JsonProperty("uuid")
  private String uuid = null;

  @JsonProperty("pseudonymized")
  private Boolean pseudonymized = null;

  @JsonProperty("associatedCase")
  private CaseReferenceDto associatedCase = null;

  @JsonProperty("associatedContact")
  private ContactReferenceDto associatedContact = null;

  @JsonProperty("associatedEventParticipant")
  private EventParticipantReferenceDto associatedEventParticipant = null;

  @JsonProperty("labSampleID")
  private String labSampleID = null;

  @JsonProperty("fieldSampleID")
  private String fieldSampleID = null;

  @JsonProperty("sampleDateTime")
  private Instant sampleDateTime = null;

  @JsonProperty("reportDateTime")
  private Instant reportDateTime = null;

  @JsonProperty("reportingUser")
  private UserReferenceDto reportingUser = null;

  @JsonProperty("reportLat")
  private Double reportLat = null;

  @JsonProperty("reportLon")
  private Double reportLon = null;

  @JsonProperty("reportLatLonAccuracy")
  private Float reportLatLonAccuracy = null;

  @JsonProperty("sampleMaterial")
  private SampleMaterial sampleMaterial = null;

  @JsonProperty("sampleMaterialText")
  private String sampleMaterialText = null;

  @JsonProperty("samplePurpose")
  private SamplePurpose samplePurpose = null;

  @JsonProperty("lab")
  private FacilityReferenceDto lab = null;

  @JsonProperty("labDetails")
  private String labDetails = null;

  @JsonProperty("shipmentDate")
  private Instant shipmentDate = null;

  @JsonProperty("shipmentDetails")
  private String shipmentDetails = null;

  @JsonProperty("receivedDate")
  private Instant receivedDate = null;

  @JsonProperty("specimenCondition")
  private SpecimenCondition specimenCondition = null;

  @JsonProperty("noTestPossibleReason")
  private String noTestPossibleReason = null;

  @JsonProperty("comment")
  private String comment = null;

  @JsonProperty("sampleSource")
  private SampleSource sampleSource = null;

  @JsonProperty("referredTo")
  private SampleReferenceDto referredTo = null;

  @JsonProperty("shipped")
  private Boolean shipped = null;

  @JsonProperty("received")
  private Boolean received = null;

  @JsonProperty("pathogenTestResult")
  private PathogenTestResultType pathogenTestResult = null;

  @JsonProperty("pathogenTestingRequested")
  private Boolean pathogenTestingRequested = null;

  @JsonProperty("additionalTestingRequested")
  private Boolean additionalTestingRequested = null;

  @JsonProperty("requestedPathogenTests")
  private List<PathogenTestType> requestedPathogenTests = null;

  @JsonProperty("requestedAdditionalTests")
  private List<AdditionalTestType> requestedAdditionalTests = null;

  @JsonProperty("requestedOtherPathogenTests")
  private String requestedOtherPathogenTests = null;

  @JsonProperty("requestedOtherAdditionalTests")
  private String requestedOtherAdditionalTests = null;

  @JsonProperty("sormasToSormasOriginInfo")
  private SormasToSormasOriginInfoDto sormasToSormasOriginInfo = null;

  @JsonProperty("ownershipHandedOver")
  private Boolean ownershipHandedOver = null;

  public SampleDto creationDate(Instant creationDate) {
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

  public SampleDto changeDate(Instant changeDate) {
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

  public SampleDto uuid(String uuid) {
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

  public SampleDto pseudonymized(Boolean pseudonymized) {
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

  public SampleDto associatedCase(CaseReferenceDto associatedCase) {
    this.associatedCase = associatedCase;
    return this;
  }

   /**
   * Get associatedCase
   * @return associatedCase
  **/
  @Schema(description = "")
  public CaseReferenceDto getAssociatedCase() {
    return associatedCase;
  }

  public void setAssociatedCase(CaseReferenceDto associatedCase) {
    this.associatedCase = associatedCase;
  }

  public SampleDto associatedContact(ContactReferenceDto associatedContact) {
    this.associatedContact = associatedContact;
    return this;
  }

   /**
   * Get associatedContact
   * @return associatedContact
  **/
  @Schema(description = "")
  public ContactReferenceDto getAssociatedContact() {
    return associatedContact;
  }

  public void setAssociatedContact(ContactReferenceDto associatedContact) {
    this.associatedContact = associatedContact;
  }

  public SampleDto associatedEventParticipant(EventParticipantReferenceDto associatedEventParticipant) {
    this.associatedEventParticipant = associatedEventParticipant;
    return this;
  }

   /**
   * Get associatedEventParticipant
   * @return associatedEventParticipant
  **/
  @Schema(description = "")
  public EventParticipantReferenceDto getAssociatedEventParticipant() {
    return associatedEventParticipant;
  }

  public void setAssociatedEventParticipant(EventParticipantReferenceDto associatedEventParticipant) {
    this.associatedEventParticipant = associatedEventParticipant;
  }

  public SampleDto labSampleID(String labSampleID) {
    this.labSampleID = labSampleID;
    return this;
  }

   /**
   * Get labSampleID
   * @return labSampleID
  **/
  @Schema(description = "")
  public String getLabSampleID() {
    return labSampleID;
  }

  public void setLabSampleID(String labSampleID) {
    this.labSampleID = labSampleID;
  }

  public SampleDto fieldSampleID(String fieldSampleID) {
    this.fieldSampleID = fieldSampleID;
    return this;
  }

   /**
   * Get fieldSampleID
   * @return fieldSampleID
  **/
  @Schema(description = "")
  public String getFieldSampleID() {
    return fieldSampleID;
  }

  public void setFieldSampleID(String fieldSampleID) {
    this.fieldSampleID = fieldSampleID;
  }

  public SampleDto sampleDateTime(Instant sampleDateTime) {
    this.sampleDateTime = sampleDateTime;
    return this;
  }

   /**
   * Get sampleDateTime
   * @return sampleDateTime
  **/
  @Schema(required = true, description = "")
  public Instant getSampleDateTime() {
    return sampleDateTime;
  }

  public void setSampleDateTime(Instant sampleDateTime) {
    this.sampleDateTime = sampleDateTime;
  }

  public SampleDto reportDateTime(Instant reportDateTime) {
    this.reportDateTime = reportDateTime;
    return this;
  }

   /**
   * Get reportDateTime
   * @return reportDateTime
  **/
  @Schema(required = true, description = "")
  public Instant getReportDateTime() {
    return reportDateTime;
  }

  public void setReportDateTime(Instant reportDateTime) {
    this.reportDateTime = reportDateTime;
  }

  public SampleDto reportingUser(UserReferenceDto reportingUser) {
    this.reportingUser = reportingUser;
    return this;
  }

   /**
   * Get reportingUser
   * @return reportingUser
  **/
  @Schema(required = true, description = "")
  public UserReferenceDto getReportingUser() {
    return reportingUser;
  }

  public void setReportingUser(UserReferenceDto reportingUser) {
    this.reportingUser = reportingUser;
  }

  public SampleDto reportLat(Double reportLat) {
    this.reportLat = reportLat;
    return this;
  }

   /**
   * Get reportLat
   * @return reportLat
  **/
  @Schema(description = "")
  public Double getReportLat() {
    return reportLat;
  }

  public void setReportLat(Double reportLat) {
    this.reportLat = reportLat;
  }

  public SampleDto reportLon(Double reportLon) {
    this.reportLon = reportLon;
    return this;
  }

   /**
   * Get reportLon
   * @return reportLon
  **/
  @Schema(description = "")
  public Double getReportLon() {
    return reportLon;
  }

  public void setReportLon(Double reportLon) {
    this.reportLon = reportLon;
  }

  public SampleDto reportLatLonAccuracy(Float reportLatLonAccuracy) {
    this.reportLatLonAccuracy = reportLatLonAccuracy;
    return this;
  }

   /**
   * Get reportLatLonAccuracy
   * @return reportLatLonAccuracy
  **/
  @Schema(description = "")
  public Float getReportLatLonAccuracy() {
    return reportLatLonAccuracy;
  }

  public void setReportLatLonAccuracy(Float reportLatLonAccuracy) {
    this.reportLatLonAccuracy = reportLatLonAccuracy;
  }

  public SampleDto sampleMaterial(SampleMaterial sampleMaterial) {
    this.sampleMaterial = sampleMaterial;
    return this;
  }

   /**
   * Get sampleMaterial
   * @return sampleMaterial
  **/
  @Schema(required = true, description = "")
  public SampleMaterial getSampleMaterial() {
    return sampleMaterial;
  }

  public void setSampleMaterial(SampleMaterial sampleMaterial) {
    this.sampleMaterial = sampleMaterial;
  }

  public SampleDto sampleMaterialText(String sampleMaterialText) {
    this.sampleMaterialText = sampleMaterialText;
    return this;
  }

   /**
   * Get sampleMaterialText
   * @return sampleMaterialText
  **/
  @Schema(description = "")
  public String getSampleMaterialText() {
    return sampleMaterialText;
  }

  public void setSampleMaterialText(String sampleMaterialText) {
    this.sampleMaterialText = sampleMaterialText;
  }

  public SampleDto samplePurpose(SamplePurpose samplePurpose) {
    this.samplePurpose = samplePurpose;
    return this;
  }

   /**
   * Get samplePurpose
   * @return samplePurpose
  **/
  @Schema(required = true, description = "")
  public SamplePurpose getSamplePurpose() {
    return samplePurpose;
  }

  public void setSamplePurpose(SamplePurpose samplePurpose) {
    this.samplePurpose = samplePurpose;
  }

  public SampleDto lab(FacilityReferenceDto lab) {
    this.lab = lab;
    return this;
  }

   /**
   * Get lab
   * @return lab
  **/
  @Schema(required = true, description = "")
  public FacilityReferenceDto getLab() {
    return lab;
  }

  public void setLab(FacilityReferenceDto lab) {
    this.lab = lab;
  }

  public SampleDto labDetails(String labDetails) {
    this.labDetails = labDetails;
    return this;
  }

   /**
   * Get labDetails
   * @return labDetails
  **/
  @Schema(description = "")
  public String getLabDetails() {
    return labDetails;
  }

  public void setLabDetails(String labDetails) {
    this.labDetails = labDetails;
  }

  public SampleDto shipmentDate(Instant shipmentDate) {
    this.shipmentDate = shipmentDate;
    return this;
  }

   /**
   * Get shipmentDate
   * @return shipmentDate
  **/
  @Schema(description = "")
  public Instant getShipmentDate() {
    return shipmentDate;
  }

  public void setShipmentDate(Instant shipmentDate) {
    this.shipmentDate = shipmentDate;
  }

  public SampleDto shipmentDetails(String shipmentDetails) {
    this.shipmentDetails = shipmentDetails;
    return this;
  }

   /**
   * Get shipmentDetails
   * @return shipmentDetails
  **/
  @Schema(description = "")
  public String getShipmentDetails() {
    return shipmentDetails;
  }

  public void setShipmentDetails(String shipmentDetails) {
    this.shipmentDetails = shipmentDetails;
  }

  public SampleDto receivedDate(Instant receivedDate) {
    this.receivedDate = receivedDate;
    return this;
  }

   /**
   * Get receivedDate
   * @return receivedDate
  **/
  @Schema(description = "")
  public Instant getReceivedDate() {
    return receivedDate;
  }

  public void setReceivedDate(Instant receivedDate) {
    this.receivedDate = receivedDate;
  }

  public SampleDto specimenCondition(SpecimenCondition specimenCondition) {
    this.specimenCondition = specimenCondition;
    return this;
  }

   /**
   * Get specimenCondition
   * @return specimenCondition
  **/
  @Schema(description = "")
  public SpecimenCondition getSpecimenCondition() {
    return specimenCondition;
  }

  public void setSpecimenCondition(SpecimenCondition specimenCondition) {
    this.specimenCondition = specimenCondition;
  }

  public SampleDto noTestPossibleReason(String noTestPossibleReason) {
    this.noTestPossibleReason = noTestPossibleReason;
    return this;
  }

   /**
   * Get noTestPossibleReason
   * @return noTestPossibleReason
  **/
  @Schema(description = "")
  public String getNoTestPossibleReason() {
    return noTestPossibleReason;
  }

  public void setNoTestPossibleReason(String noTestPossibleReason) {
    this.noTestPossibleReason = noTestPossibleReason;
  }

  public SampleDto comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @Schema(description = "")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public SampleDto sampleSource(SampleSource sampleSource) {
    this.sampleSource = sampleSource;
    return this;
  }

   /**
   * Get sampleSource
   * @return sampleSource
  **/
  @Schema(description = "")
  public SampleSource getSampleSource() {
    return sampleSource;
  }

  public void setSampleSource(SampleSource sampleSource) {
    this.sampleSource = sampleSource;
  }

  public SampleDto referredTo(SampleReferenceDto referredTo) {
    this.referredTo = referredTo;
    return this;
  }

   /**
   * Get referredTo
   * @return referredTo
  **/
  @Schema(description = "")
  public SampleReferenceDto getReferredTo() {
    return referredTo;
  }

  public void setReferredTo(SampleReferenceDto referredTo) {
    this.referredTo = referredTo;
  }

  public SampleDto shipped(Boolean shipped) {
    this.shipped = shipped;
    return this;
  }

   /**
   * Get shipped
   * @return shipped
  **/
  @Schema(description = "")
  public Boolean isShipped() {
    return shipped;
  }

  public void setShipped(Boolean shipped) {
    this.shipped = shipped;
  }

  public SampleDto received(Boolean received) {
    this.received = received;
    return this;
  }

   /**
   * Get received
   * @return received
  **/
  @Schema(description = "")
  public Boolean isReceived() {
    return received;
  }

  public void setReceived(Boolean received) {
    this.received = received;
  }

  public SampleDto pathogenTestResult(PathogenTestResultType pathogenTestResult) {
    this.pathogenTestResult = pathogenTestResult;
    return this;
  }

   /**
   * Get pathogenTestResult
   * @return pathogenTestResult
  **/
  @Schema(description = "")
  public PathogenTestResultType getPathogenTestResult() {
    return pathogenTestResult;
  }

  public void setPathogenTestResult(PathogenTestResultType pathogenTestResult) {
    this.pathogenTestResult = pathogenTestResult;
  }

  public SampleDto pathogenTestingRequested(Boolean pathogenTestingRequested) {
    this.pathogenTestingRequested = pathogenTestingRequested;
    return this;
  }

   /**
   * Get pathogenTestingRequested
   * @return pathogenTestingRequested
  **/
  @Schema(description = "")
  public Boolean isPathogenTestingRequested() {
    return pathogenTestingRequested;
  }

  public void setPathogenTestingRequested(Boolean pathogenTestingRequested) {
    this.pathogenTestingRequested = pathogenTestingRequested;
  }

  public SampleDto additionalTestingRequested(Boolean additionalTestingRequested) {
    this.additionalTestingRequested = additionalTestingRequested;
    return this;
  }

   /**
   * Get additionalTestingRequested
   * @return additionalTestingRequested
  **/
  @Schema(description = "")
  public Boolean isAdditionalTestingRequested() {
    return additionalTestingRequested;
  }

  public void setAdditionalTestingRequested(Boolean additionalTestingRequested) {
    this.additionalTestingRequested = additionalTestingRequested;
  }

  public SampleDto requestedPathogenTests(List<PathogenTestType> requestedPathogenTests) {
    this.requestedPathogenTests = requestedPathogenTests;
    return this;
  }

  public SampleDto addRequestedPathogenTestsItem(PathogenTestType requestedPathogenTestsItem) {
    if (this.requestedPathogenTests == null) {
      this.requestedPathogenTests = new ArrayList<>();
    }
    this.requestedPathogenTests.add(requestedPathogenTestsItem);
    return this;
  }

   /**
   * Get requestedPathogenTests
   * @return requestedPathogenTests
  **/
  @Schema(description = "")
  public List<PathogenTestType> getRequestedPathogenTests() {
    return requestedPathogenTests;
  }

  public void setRequestedPathogenTests(List<PathogenTestType> requestedPathogenTests) {
    this.requestedPathogenTests = requestedPathogenTests;
  }

  public SampleDto requestedAdditionalTests(List<AdditionalTestType> requestedAdditionalTests) {
    this.requestedAdditionalTests = requestedAdditionalTests;
    return this;
  }

  public SampleDto addRequestedAdditionalTestsItem(AdditionalTestType requestedAdditionalTestsItem) {
    if (this.requestedAdditionalTests == null) {
      this.requestedAdditionalTests = new ArrayList<>();
    }
    this.requestedAdditionalTests.add(requestedAdditionalTestsItem);
    return this;
  }

   /**
   * Get requestedAdditionalTests
   * @return requestedAdditionalTests
  **/
  @Schema(description = "")
  public List<AdditionalTestType> getRequestedAdditionalTests() {
    return requestedAdditionalTests;
  }

  public void setRequestedAdditionalTests(List<AdditionalTestType> requestedAdditionalTests) {
    this.requestedAdditionalTests = requestedAdditionalTests;
  }

  public SampleDto requestedOtherPathogenTests(String requestedOtherPathogenTests) {
    this.requestedOtherPathogenTests = requestedOtherPathogenTests;
    return this;
  }

   /**
   * Get requestedOtherPathogenTests
   * @return requestedOtherPathogenTests
  **/
  @Schema(description = "")
  public String getRequestedOtherPathogenTests() {
    return requestedOtherPathogenTests;
  }

  public void setRequestedOtherPathogenTests(String requestedOtherPathogenTests) {
    this.requestedOtherPathogenTests = requestedOtherPathogenTests;
  }

  public SampleDto requestedOtherAdditionalTests(String requestedOtherAdditionalTests) {
    this.requestedOtherAdditionalTests = requestedOtherAdditionalTests;
    return this;
  }

   /**
   * Get requestedOtherAdditionalTests
   * @return requestedOtherAdditionalTests
  **/
  @Schema(description = "")
  public String getRequestedOtherAdditionalTests() {
    return requestedOtherAdditionalTests;
  }

  public void setRequestedOtherAdditionalTests(String requestedOtherAdditionalTests) {
    this.requestedOtherAdditionalTests = requestedOtherAdditionalTests;
  }

  public SampleDto sormasToSormasOriginInfo(SormasToSormasOriginInfoDto sormasToSormasOriginInfo) {
    this.sormasToSormasOriginInfo = sormasToSormasOriginInfo;
    return this;
  }

   /**
   * Get sormasToSormasOriginInfo
   * @return sormasToSormasOriginInfo
  **/
  @Schema(description = "")
  public SormasToSormasOriginInfoDto getSormasToSormasOriginInfo() {
    return sormasToSormasOriginInfo;
  }

  public void setSormasToSormasOriginInfo(SormasToSormasOriginInfoDto sormasToSormasOriginInfo) {
    this.sormasToSormasOriginInfo = sormasToSormasOriginInfo;
  }

  public SampleDto ownershipHandedOver(Boolean ownershipHandedOver) {
    this.ownershipHandedOver = ownershipHandedOver;
    return this;
  }

   /**
   * Get ownershipHandedOver
   * @return ownershipHandedOver
  **/
  @Schema(description = "")
  public Boolean isOwnershipHandedOver() {
    return ownershipHandedOver;
  }

  public void setOwnershipHandedOver(Boolean ownershipHandedOver) {
    this.ownershipHandedOver = ownershipHandedOver;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SampleDto sampleDto = (SampleDto) o;
    return Objects.equals(this.creationDate, sampleDto.creationDate) &&
        Objects.equals(this.changeDate, sampleDto.changeDate) &&
        Objects.equals(this.uuid, sampleDto.uuid) &&
        Objects.equals(this.pseudonymized, sampleDto.pseudonymized) &&
        Objects.equals(this.associatedCase, sampleDto.associatedCase) &&
        Objects.equals(this.associatedContact, sampleDto.associatedContact) &&
        Objects.equals(this.associatedEventParticipant, sampleDto.associatedEventParticipant) &&
        Objects.equals(this.labSampleID, sampleDto.labSampleID) &&
        Objects.equals(this.fieldSampleID, sampleDto.fieldSampleID) &&
        Objects.equals(this.sampleDateTime, sampleDto.sampleDateTime) &&
        Objects.equals(this.reportDateTime, sampleDto.reportDateTime) &&
        Objects.equals(this.reportingUser, sampleDto.reportingUser) &&
        Objects.equals(this.reportLat, sampleDto.reportLat) &&
        Objects.equals(this.reportLon, sampleDto.reportLon) &&
        Objects.equals(this.reportLatLonAccuracy, sampleDto.reportLatLonAccuracy) &&
        Objects.equals(this.sampleMaterial, sampleDto.sampleMaterial) &&
        Objects.equals(this.sampleMaterialText, sampleDto.sampleMaterialText) &&
        Objects.equals(this.samplePurpose, sampleDto.samplePurpose) &&
        Objects.equals(this.lab, sampleDto.lab) &&
        Objects.equals(this.labDetails, sampleDto.labDetails) &&
        Objects.equals(this.shipmentDate, sampleDto.shipmentDate) &&
        Objects.equals(this.shipmentDetails, sampleDto.shipmentDetails) &&
        Objects.equals(this.receivedDate, sampleDto.receivedDate) &&
        Objects.equals(this.specimenCondition, sampleDto.specimenCondition) &&
        Objects.equals(this.noTestPossibleReason, sampleDto.noTestPossibleReason) &&
        Objects.equals(this.comment, sampleDto.comment) &&
        Objects.equals(this.sampleSource, sampleDto.sampleSource) &&
        Objects.equals(this.referredTo, sampleDto.referredTo) &&
        Objects.equals(this.shipped, sampleDto.shipped) &&
        Objects.equals(this.received, sampleDto.received) &&
        Objects.equals(this.pathogenTestResult, sampleDto.pathogenTestResult) &&
        Objects.equals(this.pathogenTestingRequested, sampleDto.pathogenTestingRequested) &&
        Objects.equals(this.additionalTestingRequested, sampleDto.additionalTestingRequested) &&
        Objects.equals(this.requestedPathogenTests, sampleDto.requestedPathogenTests) &&
        Objects.equals(this.requestedAdditionalTests, sampleDto.requestedAdditionalTests) &&
        Objects.equals(this.requestedOtherPathogenTests, sampleDto.requestedOtherPathogenTests) &&
        Objects.equals(this.requestedOtherAdditionalTests, sampleDto.requestedOtherAdditionalTests) &&
        Objects.equals(this.sormasToSormasOriginInfo, sampleDto.sormasToSormasOriginInfo) &&
        Objects.equals(this.ownershipHandedOver, sampleDto.ownershipHandedOver);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationDate, changeDate, uuid, pseudonymized, associatedCase, associatedContact, associatedEventParticipant, labSampleID, fieldSampleID, sampleDateTime, reportDateTime, reportingUser, reportLat, reportLon, reportLatLonAccuracy, sampleMaterial, sampleMaterialText, samplePurpose, lab, labDetails, shipmentDate, shipmentDetails, receivedDate, specimenCondition, noTestPossibleReason, comment, sampleSource, referredTo, shipped, received, pathogenTestResult, pathogenTestingRequested, additionalTestingRequested, requestedPathogenTests, requestedAdditionalTests, requestedOtherPathogenTests, requestedOtherAdditionalTests, sormasToSormasOriginInfo, ownershipHandedOver);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SampleDto {\n");
    
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    pseudonymized: ").append(toIndentedString(pseudonymized)).append("\n");
    sb.append("    associatedCase: ").append(toIndentedString(associatedCase)).append("\n");
    sb.append("    associatedContact: ").append(toIndentedString(associatedContact)).append("\n");
    sb.append("    associatedEventParticipant: ").append(toIndentedString(associatedEventParticipant)).append("\n");
    sb.append("    labSampleID: ").append(toIndentedString(labSampleID)).append("\n");
    sb.append("    fieldSampleID: ").append(toIndentedString(fieldSampleID)).append("\n");
    sb.append("    sampleDateTime: ").append(toIndentedString(sampleDateTime)).append("\n");
    sb.append("    reportDateTime: ").append(toIndentedString(reportDateTime)).append("\n");
    sb.append("    reportingUser: ").append(toIndentedString(reportingUser)).append("\n");
    sb.append("    reportLat: ").append(toIndentedString(reportLat)).append("\n");
    sb.append("    reportLon: ").append(toIndentedString(reportLon)).append("\n");
    sb.append("    reportLatLonAccuracy: ").append(toIndentedString(reportLatLonAccuracy)).append("\n");
    sb.append("    sampleMaterial: ").append(toIndentedString(sampleMaterial)).append("\n");
    sb.append("    sampleMaterialText: ").append(toIndentedString(sampleMaterialText)).append("\n");
    sb.append("    samplePurpose: ").append(toIndentedString(samplePurpose)).append("\n");
    sb.append("    lab: ").append(toIndentedString(lab)).append("\n");
    sb.append("    labDetails: ").append(toIndentedString(labDetails)).append("\n");
    sb.append("    shipmentDate: ").append(toIndentedString(shipmentDate)).append("\n");
    sb.append("    shipmentDetails: ").append(toIndentedString(shipmentDetails)).append("\n");
    sb.append("    receivedDate: ").append(toIndentedString(receivedDate)).append("\n");
    sb.append("    specimenCondition: ").append(toIndentedString(specimenCondition)).append("\n");
    sb.append("    noTestPossibleReason: ").append(toIndentedString(noTestPossibleReason)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    sampleSource: ").append(toIndentedString(sampleSource)).append("\n");
    sb.append("    referredTo: ").append(toIndentedString(referredTo)).append("\n");
    sb.append("    shipped: ").append(toIndentedString(shipped)).append("\n");
    sb.append("    received: ").append(toIndentedString(received)).append("\n");
    sb.append("    pathogenTestResult: ").append(toIndentedString(pathogenTestResult)).append("\n");
    sb.append("    pathogenTestingRequested: ").append(toIndentedString(pathogenTestingRequested)).append("\n");
    sb.append("    additionalTestingRequested: ").append(toIndentedString(additionalTestingRequested)).append("\n");
    sb.append("    requestedPathogenTests: ").append(toIndentedString(requestedPathogenTests)).append("\n");
    sb.append("    requestedAdditionalTests: ").append(toIndentedString(requestedAdditionalTests)).append("\n");
    sb.append("    requestedOtherPathogenTests: ").append(toIndentedString(requestedOtherPathogenTests)).append("\n");
    sb.append("    requestedOtherAdditionalTests: ").append(toIndentedString(requestedOtherAdditionalTests)).append("\n");
    sb.append("    sormasToSormasOriginInfo: ").append(toIndentedString(sormasToSormasOriginInfo)).append("\n");
    sb.append("    ownershipHandedOver: ").append(toIndentedString(ownershipHandedOver)).append("\n");
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
