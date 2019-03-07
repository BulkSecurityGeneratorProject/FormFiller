package ir.rabbitgrout.web.rest;

import ir.rabbitgrout.FormfillerApp;

import ir.rabbitgrout.domain.SibaAccountForm;
import ir.rabbitgrout.repository.SibaAccountFormRepository;
import ir.rabbitgrout.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static ir.rabbitgrout.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the SibaAccountFormResource REST controller.
 *
 * @see SibaAccountFormResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FormfillerApp.class)
public class SibaAccountFormResourceIntTest {

    private static final LocalDate DEFAULT_REGISTER_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_REGISTER_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_REGISTRATION_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_REGISTRATION_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_REGISTRATION_PLACE = "AAAAAAAAAA";
    private static final String UPDATED_REGISTRATION_PLACE = "BBBBBBBBBB";

    private static final String DEFAULT_REGISTRATION_CAPITAL = "AAAAAAAAAA";
    private static final String UPDATED_REGISTRATION_CAPITAL = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVITY_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVITY_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_LONG_TIME = "AAAAAAAAAA";
    private static final String UPDATED_LONG_TIME = "BBBBBBBBBB";

    private static final String DEFAULT_BOARD_MANAGEMENT_LONG = "AAAAAAAAAA";
    private static final String UPDATED_BOARD_MANAGEMENT_LONG = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER_1 = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER_2 = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FAX_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_FAX_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_PLAIN_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_PLAIN_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_REGISTRATION_PURPOSE = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_REGISTRATION_PURPOSE = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_1 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_1 = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_2 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_3 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_3 = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_4 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_4 = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_5 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_5 = "BBBBBBBBBB";

    private static final String DEFAULT_FULL_NAME_6 = "AAAAAAAAAA";
    private static final String UPDATED_FULL_NAME_6 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_1 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_2 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_3 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_3 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_4 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_4 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_5 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_5 = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NUMBER_6 = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NUMBER_6 = "BBBBBBBBBB";

    private static final String DEFAULT_SENDING_BILL_CYCLE = "AAAAAAAAAA";
    private static final String UPDATED_SENDING_BILL_CYCLE = "BBBBBBBBBB";

    private static final String DEFAULT_HOW_TO_SEND_BILL = "AAAAAAAAAA";
    private static final String UPDATED_HOW_TO_SEND_BILL = "BBBBBBBBBB";

    private static final String DEFAULT_OTHER_SERVICES = "AAAAAAAAAA";
    private static final String UPDATED_OTHER_SERVICES = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_LETTER_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_LETTER_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_LETTER_DATE = "AAAAAAAAAA";
    private static final String UPDATED_LETTER_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_LETTER_ORGANIZATION = "AAAAAAAAAA";
    private static final String UPDATED_LETTER_ORGANIZATION = "BBBBBBBBBB";

    @Autowired
    private SibaAccountFormRepository sibaAccountFormRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restSibaAccountFormMockMvc;

    private SibaAccountForm sibaAccountForm;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SibaAccountFormResource sibaAccountFormResource = new SibaAccountFormResource(sibaAccountFormRepository);
        this.restSibaAccountFormMockMvc = MockMvcBuilders.standaloneSetup(sibaAccountFormResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SibaAccountForm createEntity(EntityManager em) {
        SibaAccountForm sibaAccountForm = new SibaAccountForm()
            .registerDate(DEFAULT_REGISTER_DATE)
            .registrationNumber(DEFAULT_REGISTRATION_NUMBER)
            .registrationPlace(DEFAULT_REGISTRATION_PLACE)
            .registrationCapital(DEFAULT_REGISTRATION_CAPITAL)
            .activityType(DEFAULT_ACTIVITY_TYPE)
            .longTime(DEFAULT_LONG_TIME)
            .boardManagementLong(DEFAULT_BOARD_MANAGEMENT_LONG)
            .phoneNumber1(DEFAULT_PHONE_NUMBER_1)
            .phoneNumber2(DEFAULT_PHONE_NUMBER_2)
            .faxNumber(DEFAULT_FAX_NUMBER)
            .zipCode(DEFAULT_ZIP_CODE)
            .emailAddress(DEFAULT_EMAIL_ADDRESS)
            .plainAddress(DEFAULT_PLAIN_ADDRESS)
            .accountRegistrationPurpose(DEFAULT_ACCOUNT_REGISTRATION_PURPOSE)
            .fullName1(DEFAULT_FULL_NAME_1)
            .fullName2(DEFAULT_FULL_NAME_2)
            .fullName3(DEFAULT_FULL_NAME_3)
            .fullName4(DEFAULT_FULL_NAME_4)
            .fullName5(DEFAULT_FULL_NAME_5)
            .fullName6(DEFAULT_FULL_NAME_6)
            .customerNumber1(DEFAULT_CUSTOMER_NUMBER_1)
            .customerNumber2(DEFAULT_CUSTOMER_NUMBER_2)
            .customerNumber3(DEFAULT_CUSTOMER_NUMBER_3)
            .customerNumber4(DEFAULT_CUSTOMER_NUMBER_4)
            .customerNumber5(DEFAULT_CUSTOMER_NUMBER_5)
            .customerNumber6(DEFAULT_CUSTOMER_NUMBER_6)
            .sendingBillCycle(DEFAULT_SENDING_BILL_CYCLE)
            .howToSendBill(DEFAULT_HOW_TO_SEND_BILL)
            .otherServices(DEFAULT_OTHER_SERVICES)
            .accountType(DEFAULT_ACCOUNT_TYPE)
            .letterNumber(DEFAULT_LETTER_NUMBER)
            .letterDate(DEFAULT_LETTER_DATE)
            .letterOrganization(DEFAULT_LETTER_ORGANIZATION);
        return sibaAccountForm;
    }

    @Before
    public void initTest() {
        sibaAccountForm = createEntity(em);
    }

    @Test
    @Transactional
    public void createSibaAccountForm() throws Exception {
        int databaseSizeBeforeCreate = sibaAccountFormRepository.findAll().size();

        // Create the SibaAccountForm
        restSibaAccountFormMockMvc.perform(post("/api/siba-account-forms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sibaAccountForm)))
            .andExpect(status().isCreated());

        // Validate the SibaAccountForm in the database
        List<SibaAccountForm> sibaAccountFormList = sibaAccountFormRepository.findAll();
        assertThat(sibaAccountFormList).hasSize(databaseSizeBeforeCreate + 1);
        SibaAccountForm testSibaAccountForm = sibaAccountFormList.get(sibaAccountFormList.size() - 1);
        assertThat(testSibaAccountForm.getRegisterDate()).isEqualTo(DEFAULT_REGISTER_DATE);
        assertThat(testSibaAccountForm.getRegistrationNumber()).isEqualTo(DEFAULT_REGISTRATION_NUMBER);
        assertThat(testSibaAccountForm.getRegistrationPlace()).isEqualTo(DEFAULT_REGISTRATION_PLACE);
        assertThat(testSibaAccountForm.getRegistrationCapital()).isEqualTo(DEFAULT_REGISTRATION_CAPITAL);
        assertThat(testSibaAccountForm.getActivityType()).isEqualTo(DEFAULT_ACTIVITY_TYPE);
        assertThat(testSibaAccountForm.getLongTime()).isEqualTo(DEFAULT_LONG_TIME);
        assertThat(testSibaAccountForm.getBoardManagementLong()).isEqualTo(DEFAULT_BOARD_MANAGEMENT_LONG);
        assertThat(testSibaAccountForm.getPhoneNumber1()).isEqualTo(DEFAULT_PHONE_NUMBER_1);
        assertThat(testSibaAccountForm.getPhoneNumber2()).isEqualTo(DEFAULT_PHONE_NUMBER_2);
        assertThat(testSibaAccountForm.getFaxNumber()).isEqualTo(DEFAULT_FAX_NUMBER);
        assertThat(testSibaAccountForm.getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(testSibaAccountForm.getEmailAddress()).isEqualTo(DEFAULT_EMAIL_ADDRESS);
        assertThat(testSibaAccountForm.getPlainAddress()).isEqualTo(DEFAULT_PLAIN_ADDRESS);
        assertThat(testSibaAccountForm.getAccountRegistrationPurpose()).isEqualTo(DEFAULT_ACCOUNT_REGISTRATION_PURPOSE);
        assertThat(testSibaAccountForm.getFullName1()).isEqualTo(DEFAULT_FULL_NAME_1);
        assertThat(testSibaAccountForm.getFullName2()).isEqualTo(DEFAULT_FULL_NAME_2);
        assertThat(testSibaAccountForm.getFullName3()).isEqualTo(DEFAULT_FULL_NAME_3);
        assertThat(testSibaAccountForm.getFullName4()).isEqualTo(DEFAULT_FULL_NAME_4);
        assertThat(testSibaAccountForm.getFullName5()).isEqualTo(DEFAULT_FULL_NAME_5);
        assertThat(testSibaAccountForm.getFullName6()).isEqualTo(DEFAULT_FULL_NAME_6);
        assertThat(testSibaAccountForm.getCustomerNumber1()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_1);
        assertThat(testSibaAccountForm.getCustomerNumber2()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_2);
        assertThat(testSibaAccountForm.getCustomerNumber3()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_3);
        assertThat(testSibaAccountForm.getCustomerNumber4()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_4);
        assertThat(testSibaAccountForm.getCustomerNumber5()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_5);
        assertThat(testSibaAccountForm.getCustomerNumber6()).isEqualTo(DEFAULT_CUSTOMER_NUMBER_6);
        assertThat(testSibaAccountForm.getSendingBillCycle()).isEqualTo(DEFAULT_SENDING_BILL_CYCLE);
        assertThat(testSibaAccountForm.getHowToSendBill()).isEqualTo(DEFAULT_HOW_TO_SEND_BILL);
        assertThat(testSibaAccountForm.getOtherServices()).isEqualTo(DEFAULT_OTHER_SERVICES);
        assertThat(testSibaAccountForm.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
        assertThat(testSibaAccountForm.getLetterNumber()).isEqualTo(DEFAULT_LETTER_NUMBER);
        assertThat(testSibaAccountForm.getLetterDate()).isEqualTo(DEFAULT_LETTER_DATE);
        assertThat(testSibaAccountForm.getLetterOrganization()).isEqualTo(DEFAULT_LETTER_ORGANIZATION);
    }

    @Test
    @Transactional
    public void createSibaAccountFormWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sibaAccountFormRepository.findAll().size();

        // Create the SibaAccountForm with an existing ID
        sibaAccountForm.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSibaAccountFormMockMvc.perform(post("/api/siba-account-forms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sibaAccountForm)))
            .andExpect(status().isBadRequest());

        // Validate the SibaAccountForm in the database
        List<SibaAccountForm> sibaAccountFormList = sibaAccountFormRepository.findAll();
        assertThat(sibaAccountFormList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllSibaAccountForms() throws Exception {
        // Initialize the database
        sibaAccountFormRepository.saveAndFlush(sibaAccountForm);

        // Get all the sibaAccountFormList
        restSibaAccountFormMockMvc.perform(get("/api/siba-account-forms?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sibaAccountForm.getId().intValue())))
            .andExpect(jsonPath("$.[*].registerDate").value(hasItem(DEFAULT_REGISTER_DATE.toString())))
            .andExpect(jsonPath("$.[*].registrationNumber").value(hasItem(DEFAULT_REGISTRATION_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].registrationPlace").value(hasItem(DEFAULT_REGISTRATION_PLACE.toString())))
            .andExpect(jsonPath("$.[*].registrationCapital").value(hasItem(DEFAULT_REGISTRATION_CAPITAL.toString())))
            .andExpect(jsonPath("$.[*].activityType").value(hasItem(DEFAULT_ACTIVITY_TYPE.toString())))
            .andExpect(jsonPath("$.[*].longTime").value(hasItem(DEFAULT_LONG_TIME.toString())))
            .andExpect(jsonPath("$.[*].boardManagementLong").value(hasItem(DEFAULT_BOARD_MANAGEMENT_LONG.toString())))
            .andExpect(jsonPath("$.[*].phoneNumber1").value(hasItem(DEFAULT_PHONE_NUMBER_1.toString())))
            .andExpect(jsonPath("$.[*].phoneNumber2").value(hasItem(DEFAULT_PHONE_NUMBER_2.toString())))
            .andExpect(jsonPath("$.[*].faxNumber").value(hasItem(DEFAULT_FAX_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].zipCode").value(hasItem(DEFAULT_ZIP_CODE.toString())))
            .andExpect(jsonPath("$.[*].emailAddress").value(hasItem(DEFAULT_EMAIL_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].plainAddress").value(hasItem(DEFAULT_PLAIN_ADDRESS.toString())))
            .andExpect(jsonPath("$.[*].accountRegistrationPurpose").value(hasItem(DEFAULT_ACCOUNT_REGISTRATION_PURPOSE.toString())))
            .andExpect(jsonPath("$.[*].fullName1").value(hasItem(DEFAULT_FULL_NAME_1.toString())))
            .andExpect(jsonPath("$.[*].fullName2").value(hasItem(DEFAULT_FULL_NAME_2.toString())))
            .andExpect(jsonPath("$.[*].fullName3").value(hasItem(DEFAULT_FULL_NAME_3.toString())))
            .andExpect(jsonPath("$.[*].fullName4").value(hasItem(DEFAULT_FULL_NAME_4.toString())))
            .andExpect(jsonPath("$.[*].fullName5").value(hasItem(DEFAULT_FULL_NAME_5.toString())))
            .andExpect(jsonPath("$.[*].fullName6").value(hasItem(DEFAULT_FULL_NAME_6.toString())))
            .andExpect(jsonPath("$.[*].customerNumber1").value(hasItem(DEFAULT_CUSTOMER_NUMBER_1.toString())))
            .andExpect(jsonPath("$.[*].customerNumber2").value(hasItem(DEFAULT_CUSTOMER_NUMBER_2.toString())))
            .andExpect(jsonPath("$.[*].customerNumber3").value(hasItem(DEFAULT_CUSTOMER_NUMBER_3.toString())))
            .andExpect(jsonPath("$.[*].customerNumber4").value(hasItem(DEFAULT_CUSTOMER_NUMBER_4.toString())))
            .andExpect(jsonPath("$.[*].customerNumber5").value(hasItem(DEFAULT_CUSTOMER_NUMBER_5.toString())))
            .andExpect(jsonPath("$.[*].customerNumber6").value(hasItem(DEFAULT_CUSTOMER_NUMBER_6.toString())))
            .andExpect(jsonPath("$.[*].sendingBillCycle").value(hasItem(DEFAULT_SENDING_BILL_CYCLE.toString())))
            .andExpect(jsonPath("$.[*].howToSendBill").value(hasItem(DEFAULT_HOW_TO_SEND_BILL.toString())))
            .andExpect(jsonPath("$.[*].otherServices").value(hasItem(DEFAULT_OTHER_SERVICES.toString())))
            .andExpect(jsonPath("$.[*].accountType").value(hasItem(DEFAULT_ACCOUNT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].letterNumber").value(hasItem(DEFAULT_LETTER_NUMBER.toString())))
            .andExpect(jsonPath("$.[*].letterDate").value(hasItem(DEFAULT_LETTER_DATE.toString())))
            .andExpect(jsonPath("$.[*].letterOrganization").value(hasItem(DEFAULT_LETTER_ORGANIZATION.toString())));
    }
    
    @Test
    @Transactional
    public void getSibaAccountForm() throws Exception {
        // Initialize the database
        sibaAccountFormRepository.saveAndFlush(sibaAccountForm);

        // Get the sibaAccountForm
        restSibaAccountFormMockMvc.perform(get("/api/siba-account-forms/{id}", sibaAccountForm.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sibaAccountForm.getId().intValue()))
            .andExpect(jsonPath("$.registerDate").value(DEFAULT_REGISTER_DATE.toString()))
            .andExpect(jsonPath("$.registrationNumber").value(DEFAULT_REGISTRATION_NUMBER.toString()))
            .andExpect(jsonPath("$.registrationPlace").value(DEFAULT_REGISTRATION_PLACE.toString()))
            .andExpect(jsonPath("$.registrationCapital").value(DEFAULT_REGISTRATION_CAPITAL.toString()))
            .andExpect(jsonPath("$.activityType").value(DEFAULT_ACTIVITY_TYPE.toString()))
            .andExpect(jsonPath("$.longTime").value(DEFAULT_LONG_TIME.toString()))
            .andExpect(jsonPath("$.boardManagementLong").value(DEFAULT_BOARD_MANAGEMENT_LONG.toString()))
            .andExpect(jsonPath("$.phoneNumber1").value(DEFAULT_PHONE_NUMBER_1.toString()))
            .andExpect(jsonPath("$.phoneNumber2").value(DEFAULT_PHONE_NUMBER_2.toString()))
            .andExpect(jsonPath("$.faxNumber").value(DEFAULT_FAX_NUMBER.toString()))
            .andExpect(jsonPath("$.zipCode").value(DEFAULT_ZIP_CODE.toString()))
            .andExpect(jsonPath("$.emailAddress").value(DEFAULT_EMAIL_ADDRESS.toString()))
            .andExpect(jsonPath("$.plainAddress").value(DEFAULT_PLAIN_ADDRESS.toString()))
            .andExpect(jsonPath("$.accountRegistrationPurpose").value(DEFAULT_ACCOUNT_REGISTRATION_PURPOSE.toString()))
            .andExpect(jsonPath("$.fullName1").value(DEFAULT_FULL_NAME_1.toString()))
            .andExpect(jsonPath("$.fullName2").value(DEFAULT_FULL_NAME_2.toString()))
            .andExpect(jsonPath("$.fullName3").value(DEFAULT_FULL_NAME_3.toString()))
            .andExpect(jsonPath("$.fullName4").value(DEFAULT_FULL_NAME_4.toString()))
            .andExpect(jsonPath("$.fullName5").value(DEFAULT_FULL_NAME_5.toString()))
            .andExpect(jsonPath("$.fullName6").value(DEFAULT_FULL_NAME_6.toString()))
            .andExpect(jsonPath("$.customerNumber1").value(DEFAULT_CUSTOMER_NUMBER_1.toString()))
            .andExpect(jsonPath("$.customerNumber2").value(DEFAULT_CUSTOMER_NUMBER_2.toString()))
            .andExpect(jsonPath("$.customerNumber3").value(DEFAULT_CUSTOMER_NUMBER_3.toString()))
            .andExpect(jsonPath("$.customerNumber4").value(DEFAULT_CUSTOMER_NUMBER_4.toString()))
            .andExpect(jsonPath("$.customerNumber5").value(DEFAULT_CUSTOMER_NUMBER_5.toString()))
            .andExpect(jsonPath("$.customerNumber6").value(DEFAULT_CUSTOMER_NUMBER_6.toString()))
            .andExpect(jsonPath("$.sendingBillCycle").value(DEFAULT_SENDING_BILL_CYCLE.toString()))
            .andExpect(jsonPath("$.howToSendBill").value(DEFAULT_HOW_TO_SEND_BILL.toString()))
            .andExpect(jsonPath("$.otherServices").value(DEFAULT_OTHER_SERVICES.toString()))
            .andExpect(jsonPath("$.accountType").value(DEFAULT_ACCOUNT_TYPE.toString()))
            .andExpect(jsonPath("$.letterNumber").value(DEFAULT_LETTER_NUMBER.toString()))
            .andExpect(jsonPath("$.letterDate").value(DEFAULT_LETTER_DATE.toString()))
            .andExpect(jsonPath("$.letterOrganization").value(DEFAULT_LETTER_ORGANIZATION.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingSibaAccountForm() throws Exception {
        // Get the sibaAccountForm
        restSibaAccountFormMockMvc.perform(get("/api/siba-account-forms/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSibaAccountForm() throws Exception {
        // Initialize the database
        sibaAccountFormRepository.saveAndFlush(sibaAccountForm);

        int databaseSizeBeforeUpdate = sibaAccountFormRepository.findAll().size();

        // Update the sibaAccountForm
        SibaAccountForm updatedSibaAccountForm = sibaAccountFormRepository.findById(sibaAccountForm.getId()).get();
        // Disconnect from session so that the updates on updatedSibaAccountForm are not directly saved in db
        em.detach(updatedSibaAccountForm);
        updatedSibaAccountForm
            .registerDate(UPDATED_REGISTER_DATE)
            .registrationNumber(UPDATED_REGISTRATION_NUMBER)
            .registrationPlace(UPDATED_REGISTRATION_PLACE)
            .registrationCapital(UPDATED_REGISTRATION_CAPITAL)
            .activityType(UPDATED_ACTIVITY_TYPE)
            .longTime(UPDATED_LONG_TIME)
            .boardManagementLong(UPDATED_BOARD_MANAGEMENT_LONG)
            .phoneNumber1(UPDATED_PHONE_NUMBER_1)
            .phoneNumber2(UPDATED_PHONE_NUMBER_2)
            .faxNumber(UPDATED_FAX_NUMBER)
            .zipCode(UPDATED_ZIP_CODE)
            .emailAddress(UPDATED_EMAIL_ADDRESS)
            .plainAddress(UPDATED_PLAIN_ADDRESS)
            .accountRegistrationPurpose(UPDATED_ACCOUNT_REGISTRATION_PURPOSE)
            .fullName1(UPDATED_FULL_NAME_1)
            .fullName2(UPDATED_FULL_NAME_2)
            .fullName3(UPDATED_FULL_NAME_3)
            .fullName4(UPDATED_FULL_NAME_4)
            .fullName5(UPDATED_FULL_NAME_5)
            .fullName6(UPDATED_FULL_NAME_6)
            .customerNumber1(UPDATED_CUSTOMER_NUMBER_1)
            .customerNumber2(UPDATED_CUSTOMER_NUMBER_2)
            .customerNumber3(UPDATED_CUSTOMER_NUMBER_3)
            .customerNumber4(UPDATED_CUSTOMER_NUMBER_4)
            .customerNumber5(UPDATED_CUSTOMER_NUMBER_5)
            .customerNumber6(UPDATED_CUSTOMER_NUMBER_6)
            .sendingBillCycle(UPDATED_SENDING_BILL_CYCLE)
            .howToSendBill(UPDATED_HOW_TO_SEND_BILL)
            .otherServices(UPDATED_OTHER_SERVICES)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .letterNumber(UPDATED_LETTER_NUMBER)
            .letterDate(UPDATED_LETTER_DATE)
            .letterOrganization(UPDATED_LETTER_ORGANIZATION);

        restSibaAccountFormMockMvc.perform(put("/api/siba-account-forms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSibaAccountForm)))
            .andExpect(status().isOk());

        // Validate the SibaAccountForm in the database
        List<SibaAccountForm> sibaAccountFormList = sibaAccountFormRepository.findAll();
        assertThat(sibaAccountFormList).hasSize(databaseSizeBeforeUpdate);
        SibaAccountForm testSibaAccountForm = sibaAccountFormList.get(sibaAccountFormList.size() - 1);
        assertThat(testSibaAccountForm.getRegisterDate()).isEqualTo(UPDATED_REGISTER_DATE);
        assertThat(testSibaAccountForm.getRegistrationNumber()).isEqualTo(UPDATED_REGISTRATION_NUMBER);
        assertThat(testSibaAccountForm.getRegistrationPlace()).isEqualTo(UPDATED_REGISTRATION_PLACE);
        assertThat(testSibaAccountForm.getRegistrationCapital()).isEqualTo(UPDATED_REGISTRATION_CAPITAL);
        assertThat(testSibaAccountForm.getActivityType()).isEqualTo(UPDATED_ACTIVITY_TYPE);
        assertThat(testSibaAccountForm.getLongTime()).isEqualTo(UPDATED_LONG_TIME);
        assertThat(testSibaAccountForm.getBoardManagementLong()).isEqualTo(UPDATED_BOARD_MANAGEMENT_LONG);
        assertThat(testSibaAccountForm.getPhoneNumber1()).isEqualTo(UPDATED_PHONE_NUMBER_1);
        assertThat(testSibaAccountForm.getPhoneNumber2()).isEqualTo(UPDATED_PHONE_NUMBER_2);
        assertThat(testSibaAccountForm.getFaxNumber()).isEqualTo(UPDATED_FAX_NUMBER);
        assertThat(testSibaAccountForm.getZipCode()).isEqualTo(UPDATED_ZIP_CODE);
        assertThat(testSibaAccountForm.getEmailAddress()).isEqualTo(UPDATED_EMAIL_ADDRESS);
        assertThat(testSibaAccountForm.getPlainAddress()).isEqualTo(UPDATED_PLAIN_ADDRESS);
        assertThat(testSibaAccountForm.getAccountRegistrationPurpose()).isEqualTo(UPDATED_ACCOUNT_REGISTRATION_PURPOSE);
        assertThat(testSibaAccountForm.getFullName1()).isEqualTo(UPDATED_FULL_NAME_1);
        assertThat(testSibaAccountForm.getFullName2()).isEqualTo(UPDATED_FULL_NAME_2);
        assertThat(testSibaAccountForm.getFullName3()).isEqualTo(UPDATED_FULL_NAME_3);
        assertThat(testSibaAccountForm.getFullName4()).isEqualTo(UPDATED_FULL_NAME_4);
        assertThat(testSibaAccountForm.getFullName5()).isEqualTo(UPDATED_FULL_NAME_5);
        assertThat(testSibaAccountForm.getFullName6()).isEqualTo(UPDATED_FULL_NAME_6);
        assertThat(testSibaAccountForm.getCustomerNumber1()).isEqualTo(UPDATED_CUSTOMER_NUMBER_1);
        assertThat(testSibaAccountForm.getCustomerNumber2()).isEqualTo(UPDATED_CUSTOMER_NUMBER_2);
        assertThat(testSibaAccountForm.getCustomerNumber3()).isEqualTo(UPDATED_CUSTOMER_NUMBER_3);
        assertThat(testSibaAccountForm.getCustomerNumber4()).isEqualTo(UPDATED_CUSTOMER_NUMBER_4);
        assertThat(testSibaAccountForm.getCustomerNumber5()).isEqualTo(UPDATED_CUSTOMER_NUMBER_5);
        assertThat(testSibaAccountForm.getCustomerNumber6()).isEqualTo(UPDATED_CUSTOMER_NUMBER_6);
        assertThat(testSibaAccountForm.getSendingBillCycle()).isEqualTo(UPDATED_SENDING_BILL_CYCLE);
        assertThat(testSibaAccountForm.getHowToSendBill()).isEqualTo(UPDATED_HOW_TO_SEND_BILL);
        assertThat(testSibaAccountForm.getOtherServices()).isEqualTo(UPDATED_OTHER_SERVICES);
        assertThat(testSibaAccountForm.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
        assertThat(testSibaAccountForm.getLetterNumber()).isEqualTo(UPDATED_LETTER_NUMBER);
        assertThat(testSibaAccountForm.getLetterDate()).isEqualTo(UPDATED_LETTER_DATE);
        assertThat(testSibaAccountForm.getLetterOrganization()).isEqualTo(UPDATED_LETTER_ORGANIZATION);
    }

    @Test
    @Transactional
    public void updateNonExistingSibaAccountForm() throws Exception {
        int databaseSizeBeforeUpdate = sibaAccountFormRepository.findAll().size();

        // Create the SibaAccountForm

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSibaAccountFormMockMvc.perform(put("/api/siba-account-forms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sibaAccountForm)))
            .andExpect(status().isBadRequest());

        // Validate the SibaAccountForm in the database
        List<SibaAccountForm> sibaAccountFormList = sibaAccountFormRepository.findAll();
        assertThat(sibaAccountFormList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSibaAccountForm() throws Exception {
        // Initialize the database
        sibaAccountFormRepository.saveAndFlush(sibaAccountForm);

        int databaseSizeBeforeDelete = sibaAccountFormRepository.findAll().size();

        // Delete the sibaAccountForm
        restSibaAccountFormMockMvc.perform(delete("/api/siba-account-forms/{id}", sibaAccountForm.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SibaAccountForm> sibaAccountFormList = sibaAccountFormRepository.findAll();
        assertThat(sibaAccountFormList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SibaAccountForm.class);
        SibaAccountForm sibaAccountForm1 = new SibaAccountForm();
        sibaAccountForm1.setId(1L);
        SibaAccountForm sibaAccountForm2 = new SibaAccountForm();
        sibaAccountForm2.setId(sibaAccountForm1.getId());
        assertThat(sibaAccountForm1).isEqualTo(sibaAccountForm2);
        sibaAccountForm2.setId(2L);
        assertThat(sibaAccountForm1).isNotEqualTo(sibaAccountForm2);
        sibaAccountForm1.setId(null);
        assertThat(sibaAccountForm1).isNotEqualTo(sibaAccountForm2);
    }
}
