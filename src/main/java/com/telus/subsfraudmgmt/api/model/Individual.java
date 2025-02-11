package com.telus.subsfraudmgmt.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telus.subsfraudmgmt.api.model.Characteristic;
import com.telus.subsfraudmgmt.api.model.ContactMediumRefOrValue;
import com.telus.subsfraudmgmt.api.model.Disability;
import com.telus.subsfraudmgmt.api.model.Entity;
import com.telus.subsfraudmgmt.api.model.ExternalReference;
import com.telus.subsfraudmgmt.api.model.IndividualIdentification;
import com.telus.subsfraudmgmt.api.model.IndividualStateType;
import com.telus.subsfraudmgmt.api.model.LanguageAbility;
import com.telus.subsfraudmgmt.api.model.OtherNameIndividual;
import com.telus.subsfraudmgmt.api.model.Party;
import com.telus.subsfraudmgmt.api.model.PartyCreditProfile;
import com.telus.subsfraudmgmt.api.model.RelatedParty;
import com.telus.subsfraudmgmt.api.model.Skill;
import com.telus.subsfraudmgmt.api.model.TaxExemptionCertificate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about.
 */
@ApiModel(description = "Individual represents a single human being (a man, woman or child). The individual can be a customer, an employee or any other person that the organization needs to store information about.")
@Validated

public class Individual extends Party  {
  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("placeOfBirth")
  private String placeOfBirth = null;

  @JsonProperty("countryOfBirth")
  private String countryOfBirth = null;

  @JsonProperty("nationality")
  private String nationality = null;

  @JsonProperty("maritalStatus")
  private String maritalStatus = null;

  @JsonProperty("birthDate")
  private String birthDate = null;

  @JsonProperty("deathDate")
  private OffsetDateTime deathDate = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("aristocraticTitle")
  private String aristocraticTitle = null;

  @JsonProperty("generation")
  private String generation = null;

  @JsonProperty("givenName")
  private String givenName = null;

  @JsonProperty("preferredGivenName")
  private String preferredGivenName = null;

  @JsonProperty("familyNamePrefix")
  private String familyNamePrefix = null;

  @JsonProperty("familyName")
  private String familyName = null;

  @JsonProperty("legalName")
  private String legalName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("formattedName")
  private String formattedName = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("status")
  private IndividualStateType status = null;

  @JsonProperty("otherName")
  @Valid
  private List<OtherNameIndividual> otherName = null;

  @JsonProperty("individualIdentification")
  @Valid
  private List<IndividualIdentification> individualIdentification = null;

  @JsonProperty("disability")
  @Valid
  private List<Disability> disability = null;

  @JsonProperty("languageAbility")
  @Valid
  private List<LanguageAbility> languageAbility = null;

  @JsonProperty("skill")
  @Valid
  private List<Skill> skill = null;

  public Individual schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A URI to a JSON-Schema file that defines additional attributes and relationships")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Individual baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return baseType
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the super-class")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Individual type(String type) {
    this.type = type;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return type
  **/
  @ApiModelProperty(value = "When sub-classing, this defines the sub-class entity name")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Individual gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Gender
   * @return gender
  **/
  @ApiModelProperty(value = "Gender")


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Individual placeOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
    return this;
  }

  /**
   * Reference to the place where the individual was born
   * @return placeOfBirth
  **/
  @ApiModelProperty(value = "Reference to the place where the individual was born")


  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public Individual countryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
    return this;
  }

  /**
   * Country where the individual was born
   * @return countryOfBirth
  **/
  @ApiModelProperty(value = "Country where the individual was born")


  public String getCountryOfBirth() {
    return countryOfBirth;
  }

  public void setCountryOfBirth(String countryOfBirth) {
    this.countryOfBirth = countryOfBirth;
  }

  public Individual nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * Nationality
   * @return nationality
  **/
  @ApiModelProperty(value = "Nationality")


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Individual maritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Marital status (married, divorced, widow ...)
   * @return maritalStatus
  **/
  @ApiModelProperty(value = "Marital status (married, divorced, widow ...)")


  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public Individual birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Birth date
   * @return birthDate
  **/
  @ApiModelProperty(value = "Birth date")

  @Valid

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public Individual deathDate(OffsetDateTime deathDate) {
    this.deathDate = deathDate;
    return this;
  }

  /**
   * Date of death
   * @return deathDate
  **/
  @ApiModelProperty(value = "Date of death")

  @Valid

  public OffsetDateTime getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(OffsetDateTime deathDate) {
    this.deathDate = deathDate;
  }

  public Individual title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...
   * @return title
  **/
  @ApiModelProperty(value = "Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Individual aristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
    return this;
  }

  /**
   * e.g. Baron, Graf, Earl,…
   * @return aristocraticTitle
  **/
  @ApiModelProperty(value = "e.g. Baron, Graf, Earl,…")


  public String getAristocraticTitle() {
    return aristocraticTitle;
  }

  public void setAristocraticTitle(String aristocraticTitle) {
    this.aristocraticTitle = aristocraticTitle;
  }

  public Individual generation(String generation) {
    this.generation = generation;
    return this;
  }

  /**
   * e.g.. Sr, Jr, III (the third),…
   * @return generation
  **/
  @ApiModelProperty(value = "e.g.. Sr, Jr, III (the third),…")


  public String getGeneration() {
    return generation;
  }

  public void setGeneration(String generation) {
    this.generation = generation;
  }

  public Individual givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * First name of the individual
   * @return givenName
  **/
  @ApiModelProperty(value = "First name of the individual")


  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public Individual preferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
    return this;
  }

  /**
   * Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname
   * @return preferredGivenName
  **/
  @ApiModelProperty(value = "Contains the chosen name by which the individual prefers to be addressed. Note: This name may be a name other than a given name, such as a nickname")


  public String getPreferredGivenName() {
    return preferredGivenName;
  }

  public void setPreferredGivenName(String preferredGivenName) {
    this.preferredGivenName = preferredGivenName;
  }

  public Individual familyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
    return this;
  }

  /**
   * Family name prefix
   * @return familyNamePrefix
  **/
  @ApiModelProperty(value = "Family name prefix")


  public String getFamilyNamePrefix() {
    return familyNamePrefix;
  }

  public void setFamilyNamePrefix(String familyNamePrefix) {
    this.familyNamePrefix = familyNamePrefix;
  }

  public Individual familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * Contains the non-chosen or inherited name. Also known as last name in the Western context
   * @return familyName
  **/
  @ApiModelProperty(value = "Contains the non-chosen or inherited name. Also known as last name in the Western context")


  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public Individual legalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

  /**
   * Legal name or birth name (name one has for official purposes)
   * @return legalName
  **/
  @ApiModelProperty(value = "Legal name or birth name (name one has for official purposes)")


  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public Individual middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middles name or initial
   * @return middleName
  **/
  @ApiModelProperty(value = "Middles name or initial")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Individual fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * Full name flatten (first, middle, and last names)
   * @return fullName
  **/
  @ApiModelProperty(value = "Full name flatten (first, middle, and last names)")


  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Individual formattedName(String formattedName) {
    this.formattedName = formattedName;
    return this;
  }

  /**
   * A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)
   * @return formattedName
  **/
  @ApiModelProperty(value = "A fully formatted name in one string with all of its pieces in their proper place and all of the necessary punctuation. Useful for specific contexts (Chinese, Japanese, Korean,…)")


  public String getFormattedName() {
    return formattedName;
  }

  public void setFormattedName(String formattedName) {
    this.formattedName = formattedName;
  }

  public Individual location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Temporary current location od the individual (may be used if the individual has approved its sharing)
   * @return location
  **/
  @ApiModelProperty(value = "Temporary current location od the individual (may be used if the individual has approved its sharing)")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Individual status(IndividualStateType status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the individual
   * @return status
  **/
  @ApiModelProperty(value = "Status of the individual")

  @Valid

  public IndividualStateType getStatus() {
    return status;
  }

  public void setStatus(IndividualStateType status) {
    this.status = status;
  }

  public Individual otherName(List<OtherNameIndividual> otherName) {
    this.otherName = otherName;
    return this;
  }

  public Individual addOtherNameItem(OtherNameIndividual otherNameItem) {
    if (this.otherName == null) {
      this.otherName = new ArrayList<>();
    }
    this.otherName.add(otherNameItem);
    return this;
  }

  /**
   * Get otherName
   * @return otherName
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OtherNameIndividual> getOtherName() {
    return otherName;
  }

  public void setOtherName(List<OtherNameIndividual> otherName) {
    this.otherName = otherName;
  }

  public Individual individualIdentification(List<IndividualIdentification> individualIdentification) {
    this.individualIdentification = individualIdentification;
    return this;
  }

  public Individual addIndividualIdentificationItem(IndividualIdentification individualIdentificationItem) {
    if (this.individualIdentification == null) {
      this.individualIdentification = new ArrayList<>();
    }
    this.individualIdentification.add(individualIdentificationItem);
    return this;
  }

  /**
   * Get individualIdentification
   * @return individualIdentification
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<IndividualIdentification> getIndividualIdentification() {
    return individualIdentification;
  }

  public void setIndividualIdentification(List<IndividualIdentification> individualIdentification) {
    this.individualIdentification = individualIdentification;
  }

  public Individual disability(List<Disability> disability) {
    this.disability = disability;
    return this;
  }

  public Individual addDisabilityItem(Disability disabilityItem) {
    if (this.disability == null) {
      this.disability = new ArrayList<>();
    }
    this.disability.add(disabilityItem);
    return this;
  }

  /**
   * Get disability
   * @return disability
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Disability> getDisability() {
    return disability;
  }

  public void setDisability(List<Disability> disability) {
    this.disability = disability;
  }

  public Individual languageAbility(List<LanguageAbility> languageAbility) {
    this.languageAbility = languageAbility;
    return this;
  }

  public Individual addLanguageAbilityItem(LanguageAbility languageAbilityItem) {
    if (this.languageAbility == null) {
      this.languageAbility = new ArrayList<>();
    }
    this.languageAbility.add(languageAbilityItem);
    return this;
  }

  /**
   * Get languageAbility
   * @return languageAbility
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<LanguageAbility> getLanguageAbility() {
    return languageAbility;
  }

  public void setLanguageAbility(List<LanguageAbility> languageAbility) {
    this.languageAbility = languageAbility;
  }

  public Individual skill(List<Skill> skill) {
    this.skill = skill;
    return this;
  }

  public Individual addSkillItem(Skill skillItem) {
    if (this.skill == null) {
      this.skill = new ArrayList<>();
    }
    this.skill.add(skillItem);
    return this;
  }

  /**
   * Get skill
   * @return skill
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Skill> getSkill() {
    return skill;
  }

  public void setSkill(List<Skill> skill) {
    this.skill = skill;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Individual individual = (Individual) o;
    return Objects.equals(this.schemaLocation, individual.schemaLocation) &&
        Objects.equals(this.baseType, individual.baseType) &&
        Objects.equals(this.type, individual.type) &&
        Objects.equals(this.gender, individual.gender) &&
        Objects.equals(this.placeOfBirth, individual.placeOfBirth) &&
        Objects.equals(this.countryOfBirth, individual.countryOfBirth) &&
        Objects.equals(this.nationality, individual.nationality) &&
        Objects.equals(this.maritalStatus, individual.maritalStatus) &&
        Objects.equals(this.birthDate, individual.birthDate) &&
        Objects.equals(this.deathDate, individual.deathDate) &&
        Objects.equals(this.title, individual.title) &&
        Objects.equals(this.aristocraticTitle, individual.aristocraticTitle) &&
        Objects.equals(this.generation, individual.generation) &&
        Objects.equals(this.givenName, individual.givenName) &&
        Objects.equals(this.preferredGivenName, individual.preferredGivenName) &&
        Objects.equals(this.familyNamePrefix, individual.familyNamePrefix) &&
        Objects.equals(this.familyName, individual.familyName) &&
        Objects.equals(this.legalName, individual.legalName) &&
        Objects.equals(this.middleName, individual.middleName) &&
        Objects.equals(this.fullName, individual.fullName) &&
        Objects.equals(this.formattedName, individual.formattedName) &&
        Objects.equals(this.location, individual.location) &&
        Objects.equals(this.status, individual.status) &&
        Objects.equals(this.otherName, individual.otherName) &&
        Objects.equals(this.individualIdentification, individual.individualIdentification) &&
        Objects.equals(this.disability, individual.disability) &&
        Objects.equals(this.languageAbility, individual.languageAbility) &&
        Objects.equals(this.skill, individual.skill) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemaLocation, baseType, type, gender, placeOfBirth, countryOfBirth, nationality, maritalStatus, birthDate, deathDate, title, aristocraticTitle, generation, givenName, preferredGivenName, familyNamePrefix, familyName, legalName, middleName, fullName, formattedName, location, status, otherName, individualIdentification, disability, languageAbility, skill, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Individual {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    placeOfBirth: ").append(toIndentedString(placeOfBirth)).append("\n");
    sb.append("    countryOfBirth: ").append(toIndentedString(countryOfBirth)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    deathDate: ").append(toIndentedString(deathDate)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    aristocraticTitle: ").append(toIndentedString(aristocraticTitle)).append("\n");
    sb.append("    generation: ").append(toIndentedString(generation)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    preferredGivenName: ").append(toIndentedString(preferredGivenName)).append("\n");
    sb.append("    familyNamePrefix: ").append(toIndentedString(familyNamePrefix)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    formattedName: ").append(toIndentedString(formattedName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    otherName: ").append(toIndentedString(otherName)).append("\n");
    sb.append("    individualIdentification: ").append(toIndentedString(individualIdentification)).append("\n");
    sb.append("    disability: ").append(toIndentedString(disability)).append("\n");
    sb.append("    languageAbility: ").append(toIndentedString(languageAbility)).append("\n");
    sb.append("    skill: ").append(toIndentedString(skill)).append("\n");
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

