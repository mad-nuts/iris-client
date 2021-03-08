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
import de.healthIMIS.sormas.client.model.ClassificationCaseCriteriaDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
/**
 * ClassificationNotInStartDateRangeCriteriaDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-28T11:46:54.705673+01:00[Europe/Berlin]")
public class ClassificationNotInStartDateRangeCriteriaDto extends ClassificationCaseCriteriaDto {
  @JsonProperty("daysBeforeStartDate")
  private Integer daysBeforeStartDate = null;

  public ClassificationNotInStartDateRangeCriteriaDto daysBeforeStartDate(Integer daysBeforeStartDate) {
    this.daysBeforeStartDate = daysBeforeStartDate;
    return this;
  }

   /**
   * Get daysBeforeStartDate
   * @return daysBeforeStartDate
  **/
  @Schema(description = "")
  public Integer getDaysBeforeStartDate() {
    return daysBeforeStartDate;
  }

  public void setDaysBeforeStartDate(Integer daysBeforeStartDate) {
    this.daysBeforeStartDate = daysBeforeStartDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassificationNotInStartDateRangeCriteriaDto classificationNotInStartDateRangeCriteriaDto = (ClassificationNotInStartDateRangeCriteriaDto) o;
    return Objects.equals(this.daysBeforeStartDate, classificationNotInStartDateRangeCriteriaDto.daysBeforeStartDate) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(daysBeforeStartDate, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassificationNotInStartDateRangeCriteriaDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    daysBeforeStartDate: ").append(toIndentedString(daysBeforeStartDate)).append("\n");
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
