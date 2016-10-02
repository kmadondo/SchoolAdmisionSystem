///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package zw.co.hitrac.sas;
//
//import com.mysql.jdbc.StringUtils;
//import java.net.NetworkInterface;
//import java.text.NumberFormat;
//import java.util.Enumeration;
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//import java.util.Set;
//import java.util.TreeSet;
//import java.util.logging.Logger;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.slf4j.LoggerFactory;
//import zw.co.hitrac.sas.business.domain.BaseEntity;
//
///**
// *
// * @author tndangana
// */
//public class CouncilStringUtility {
//    
//    public static final String lineSeparator = System.getProperty("line.separator");
//    private static final String likeSpecialCharacter = "%";
//    private static final Joiner joiner = Joiner.on(StringUtils.SPACE).skipNulls();
//    private static final Joiner noSpaceJoiner = Joiner.on(StringUtils.EMPTY).skipNulls();
//    private static final Logger logger = LoggerFactory.getLogger(CouncilStringUtility.class);
//    private static final String openBrace = "(";
//    private static final String closeBrace = ")";
//    private static final Pattern NO_CENTS_PATTERN = Pattern.compile("\\.00");
//    private static final Pattern COMMA_PATTERN = Pattern.compile(",", Pattern.LITERAL);
//    private static final Pattern COLON_PATTERN = Pattern.compile(";", Pattern.LITERAL);
//
//    public static String joinStrings(boolean separateWithSpace, Object... objects) {
//
//        logger.debug("Joining Strings separate space={}", separateWithSpace);
//
//        Objects.requireNonNull(objects, "objects to join are required");
//
//        if (separateWithSpace) {
//
//            return joiner.join(objects);
//
//        } else {
//
//            return noSpaceJoiner.join(objects);
//        }
//    }
//
//    public static String joinStrings(String customSeparatorString, Object... objects) {
//
//        logger.debug("Joining Strings with customer separator={}", customSeparatorString);
//
//        Validate.notEmpty(customSeparatorString, "Custom separator string is required");
//        Objects.requireNonNull(objects, "objects to join are required");
//
//        Joiner customJoiner = Joiner.on(customSeparatorString).skipNulls();
//        return customJoiner.join(objects);
//    }
//
//    public static String buildSearchTermForLikeQuery(final String textToSearch) {
//
//        logger.debug("Building search term for like query {}", textToSearch);
//
//        Validate.notEmpty(textToSearch);
//
//        return joinStrings(false, likeSpecialCharacter, textToSearch, likeSpecialCharacter);
//    }
//
//    public static String getMissingFieldMessage(final String fieldName) {
//
//        return joinStrings(true, "Validation Error.", fieldName, "is required but none was " +
//                "provided");
//
//    }
//
//    public static String getNullableWrapperPassedNullMessage() {
//
//        return "Field id cannot be null, wrap it as an Optional.empty instead if you really intend to pass null";
//    }
//
//    public static String getExistingFieldMessage(final String fieldName, final String value) {
//
//        return joinStrings(true, "Validation Error.", fieldName, value, "Already exists");
//
//    }
//
//    /**
//     * Re-used from old MDPCZ project, TODO subject to analysis and amendment
//     *
//     * @param registrationNumber
//     * @param register
//     * @param practitionerType
//     * @return
//     */
//    public static String getFormattedRegistrationNumber(
//            String registrationNumber,
//            RegisterType registerType,
//            PractitionerType practitionerType) {
//
//        Objects.requireNonNull(registerType,
//                "Cannot get registration number for registration with a register with no register type");
//        Objects.requireNonNull(practitionerType,
//                "Cannot get registration number for registration with no practitioner type");
//
//
//        if (StringUtils.isEmpty(registrationNumber)) {
//
//            return "TBA";
//
//        } else {
//
//            StringBuilder regNumberBuilder = new StringBuilder();
//            final boolean isProvisionalRegister =
//                    registerType == RegisterType.PROVISIONAL_REGISTER;
//            final boolean isPhilanthropicRegister =
//                    registerType == RegisterType.PHILANTHROPIC_REGISTER;
//            final boolean isSpecialistPhysician =
//                    practitionerType.getName()
//                            .equalsIgnoreCase(CouncilGlobalConstants.PRACTITIONER_TYPE_SPECIALIST_PHYSICIAN);
//            final boolean isMedicalPractitioner =
//                    practitionerType.getName().equalsIgnoreCase(CouncilGlobalConstants.MEDICAL_PRACTITIONER);
//            final boolean isDentalPractitioner =
//                    practitionerType.getName().equalsIgnoreCase(CouncilGlobalConstants.DENTAL_PRACTITIONER);
//            final boolean isDentalTechnician =
//                    practitionerType.getName().equalsIgnoreCase(CouncilGlobalConstants.DENTAL_TECHNICIAN);
//
//
//            //Register
//            if (isProvisionalRegister && !isSpecialistPhysician) {
//
//                regNumberBuilder.append(CouncilGlobalConstants.PROVISIONAL_REGISTER_PREFIX);
//
//                if (!isMedicalPractitioner && !isDentalPractitioner && !isDentalTechnician) {
//
//                    regNumberBuilder.append(StringUtils.SPACE);
//                }
//
//            } else if (isPhilanthropicRegister) {
//
//                regNumberBuilder
//                        .append(CouncilGlobalConstants.SHORT_TERM_PHILANTHROPIC_PREFIX)
//                        .append(StringUtils.SPACE);
//
//            }
//
//            //Practitioner Type
//            regNumberBuilder
//                    .append(practitionerType.getPrefix())
//                    .append(StringUtils.SPACE);
//
//            regNumberBuilder.append(registrationNumber);
//
//            return regNumberBuilder.toString().toUpperCase();
//
//        }
//    }
//
//    public static String getPhilanthropicFormattedRegistrationNumber(
//            String registrationNumber, PhilanthropicWorkType workType) {
//
//        Objects.requireNonNull(workType,
//                "Cannot get work type for philanthropic");
//
//        if (StringUtils.isEmpty(registrationNumber)) {
//
//            return "TBA";
//
//        } else {
//
//            StringBuilder regNumberBuilder = new StringBuilder();
//            regNumberBuilder
//                    .append(CouncilGlobalConstants.SHORT_TERM_PHILANTHROPIC_PREFIX)
//                    .append(StringUtils.SPACE);
//
//            regNumberBuilder
//                    .append(workType.getAbbreviation())
//                    .append(StringUtils.SPACE);
//
//            return regNumberBuilder.toString().toUpperCase();
//
//        }
//    }
//
//
//    public static String getFormattedQualificationName(Qualification qualification) {
//
//        Objects.requireNonNull(qualification, getMissingFieldMessage("Qualification"));
//
//        Institution university = qualification.getAwardingInstitution();
//        StringBuilder qualificationName = new StringBuilder();
//
//        final String qualificationProgrammeAbbreviation = (qualification.getProgramme() == null) ?
//                StringUtils.EMPTY : qualification.getProgramme().getAbbreviation();
//
//        if (university == null) {
//
//            qualificationName.append(qualificationProgrammeAbbreviation);
//
//        } else {
//
//            final Country country =
//                    Objects.requireNonNull(university.getCountry(), getMissingFieldMessage("University country"));
//            final String countryName =
//                    Objects.requireNonNull(country.getName(), getMissingFieldMessage("University Country name"));
//
//
//            if (CouncilGlobalConstants.ZIMBABWE.equalsIgnoreCase(countryName)) {
//
//
//                qualificationName.append(qualificationProgrammeAbbreviation)
//                        .append(StringUtils.SPACE)
//                        .append(openBrace)
//                        .append(CouncilGlobalConstants.ZIMBABWE_COUNTRY_ALIAS)
//                        .append(closeBrace);
//
//            } else {
//
//                qualificationName.append(qualificationProgrammeAbbreviation);
//
//                //Prevent duplicated university-country combinations where the university name is the same as the
//                //country name and empty-country where university has no abbreviation
//                if (StringUtils.isBlank(university.getAbbreviation()) ||
//                        Objects.equals(university.getAbbreviation(), university.getCountry().getAbbreviation())) {
//
//                    qualificationName
//                            .append(StringUtils.SPACE)
//                            .append(openBrace)
//                            .append(university.getCountry().getAbbreviation().toUpperCase())
//                            .append(closeBrace);
//
//                } else {
//
//                    qualificationName
//                            .append(StringUtils.SPACE)
//                            .append(openBrace).append(university.getAbbreviation())
//                            .append('-')
//                            .append(university.getCountry().getAbbreviation().toUpperCase())
//                            .append(closeBrace);
//                }
//            }
//        }
//
//        qualificationName.append(StringUtils.SPACE);
//        final String qualificationYear = CouncilDateUtility.getYearFromDate(qualification.getDateQualified());
//
//        qualificationName.append(qualificationYear);
//
//        return qualificationName.toString();
//    }
//
//    public static String aggregateQualifications(List<Qualification> qualifications) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (Qualification qualification : qualifications) {
//            stringBuilder.append(getFormattedQualificationName(qualification)).append("  ");
//        }
//
//        return stringBuilder.toString();
//    }
//
//    public static String formatAsCurrency(double amount) {
//
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
//        final String currencyString = numberFormat.format(amount);
//
//        return NO_CENTS_PATTERN.matcher(currencyString).replaceAll("");
//    }
//
//    public static String generateCurrentServerUniqueIdentifier() {
//
//        //Avoid duplicate interfaces, sort to prevent inconsistency
//        Set<String> identifiers = new TreeSet<>();
//
//        try {
//
//
//            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = networkInterfaces.nextElement();
//                if ((networkInterface != null) && !networkInterface.isVirtual() && !networkInterface.isLoopback()) {
//
//                    final byte[] mac = networkInterface.getHardwareAddress();
//                    if (mac != null) {
//
//                        for (int i = 0; i < mac.length; i++) {
//                            identifiers.add(String.format("%02X%s", mac[i], (i < (mac.length - 1)) ? "-" : ""));
//                        }
//
//                    }
//
//                }
//            }
//
//        } catch (Exception e) {
//            logger.error("An error occurred while generating current server identifier", e);
//
//        }
//
//
//        StringBuilder stringBuilder = new StringBuilder();
//        identifiers.forEach(i -> stringBuilder.append(i));
//
//        return stringBuilder.toString();
//
//    }
//
//    public static String cleanCSVCell(BaseUniqueNameEntity cellValue) {
//
//        if ((cellValue == null) || StringUtils.isBlank(cellValue.getName())) {
//            return "";
//        } else {
//            return cleanCSVCell(cellValue.getName());
//        }
//    }
//
//    public static String cleanCSVCell(BaseEntity cellValue) {
//
//        if ((cellValue == null) || StringUtils.isBlank(cellValue.getName())) {
//            return "";
//        } else {
//            return cleanCSVCell(cellValue.getName());
//        }
//    }
//
//    public static String cleanCSVCell(String cellValue) {
//
//        if (cellValue == null) {
//            return "";
//        } else {
//            return COLON_PATTERN.matcher(
//                    COMMA_PATTERN.matcher(cellValue)
//                            .replaceAll(Matcher.quoteReplacement(" "))
//            ).replaceAll(Matcher.quoteReplacement(" "));
//
//        }
//    }
//
//    public static String getFullName(Practitioner practitioner, boolean includeTitle, boolean firstNameComesFirst) {
//
//        StringBuilder fullName = new StringBuilder();
//
//        if (firstNameComesFirst) {
//
//            fullName.append(WordUtils.capitalizeFully(CouncilStringUtility.joinStrings(true,
//                    practitioner.getFirstName(), practitioner.getMiddleName(), practitioner.getLastName())));
//        } else {
//
//            fullName.append(WordUtils.capitalizeFully(CouncilStringUtility.joinStrings(true,
//                    practitioner.getLastName(), practitioner.getFirstName(), practitioner.getMiddleName())));
//        }
//
//        if (includeTitle && practitioner.getTitle() != null) {
//            return practitioner.getTitle().toString() + " " + fullName.toString();
//        } else {
//            return fullName.toString();
//        }
//
//    }
//    
//}
