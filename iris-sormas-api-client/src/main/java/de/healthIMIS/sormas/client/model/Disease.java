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
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Disease
 */
public enum Disease {
  AFP("AFP"),
  CHOLERA("CHOLERA"),
  CONGENITAL_RUBELLA("CONGENITAL_RUBELLA"),
  CSM("CSM"),
  DENGUE("DENGUE"),
  EVD("EVD"),
  GUINEA_WORM("GUINEA_WORM"),
  LASSA("LASSA"),
  MEASLES("MEASLES"),
  MONKEYPOX("MONKEYPOX"),
  NEW_INFLUENZA("NEW_INFLUENZA"),
  PLAGUE("PLAGUE"),
  POLIO("POLIO"),
  UNSPECIFIED_VHF("UNSPECIFIED_VHF"),
  WEST_NILE_FEVER("WEST_NILE_FEVER"),
  YELLOW_FEVER("YELLOW_FEVER"),
  RABIES("RABIES"),
  ANTHRAX("ANTHRAX"),
  CORONAVIRUS("CORONAVIRUS"),
  PNEUMONIA("PNEUMONIA"),
  MALARIA("MALARIA"),
  TYPHOID_FEVER("TYPHOID_FEVER"),
  ACUTE_VIRAL_HEPATITIS("ACUTE_VIRAL_HEPATITIS"),
  NON_NEONATAL_TETANUS("NON_NEONATAL_TETANUS"),
  HIV("HIV"),
  SCHISTOSOMIASIS("SCHISTOSOMIASIS"),
  SOIL_TRANSMITTED_HELMINTHS("SOIL_TRANSMITTED_HELMINTHS"),
  TRYPANOSOMIASIS("TRYPANOSOMIASIS"),
  DIARRHEA_DEHYDRATION("DIARRHEA_DEHYDRATION"),
  DIARRHEA_BLOOD("DIARRHEA_BLOOD"),
  SNAKE_BITE("SNAKE_BITE"),
  RUBELLA("RUBELLA"),
  TUBERCULOSIS("TUBERCULOSIS"),
  LEPROSY("LEPROSY"),
  LYMPHATIC_FILARIASIS("LYMPHATIC_FILARIASIS"),
  BURULI_ULCER("BURULI_ULCER"),
  PERTUSSIS("PERTUSSIS"),
  NEONATAL_TETANUS("NEONATAL_TETANUS"),
  ONCHOCERCIASIS("ONCHOCERCIASIS"),
  DIPHTERIA("DIPHTERIA"),
  TRACHOMA("TRACHOMA"),
  YAWS_ENDEMIC_SYPHILIS("YAWS_ENDEMIC_SYPHILIS"),
  MATERNAL_DEATHS("MATERNAL_DEATHS"),
  PERINATAL_DEATHS("PERINATAL_DEATHS"),
  INFLUENZA_A("INFLUENZA_A"),
  INFLUENZA_B("INFLUENZA_B"),
  H_METAPNEUMOVIRUS("H_METAPNEUMOVIRUS"),
  RESPIRATORY_SYNCYTIAL_VIRUS("RESPIRATORY_SYNCYTIAL_VIRUS"),
  PARAINFLUENZA_1_4("PARAINFLUENZA_1_4"),
  ADENOVIRUS("ADENOVIRUS"),
  RHINOVIRUS("RHINOVIRUS"),
  ENTEROVIRUS("ENTEROVIRUS"),
  M_PNEUMONIAE("M_PNEUMONIAE"),
  C_PNEUMONIAE("C_PNEUMONIAE"),
  OTHER("OTHER"),
  UNDEFINED("UNDEFINED");

  private String value;

  Disease(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Disease fromValue(String text) {
    for (Disease b : Disease.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
