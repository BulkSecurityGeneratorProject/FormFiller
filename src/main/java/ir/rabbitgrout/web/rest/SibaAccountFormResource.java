package ir.rabbitgrout.web.rest;
import ir.rabbitgrout.domain.SibaAccountForm;
import ir.rabbitgrout.repository.SibaAccountFormRepository;
import ir.rabbitgrout.web.rest.errors.BadRequestAlertException;
import ir.rabbitgrout.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing SibaAccountForm.
 */
@RestController
@RequestMapping("/api")
public class SibaAccountFormResource {

    private final Logger log = LoggerFactory.getLogger(SibaAccountFormResource.class);

    private static final String ENTITY_NAME = "sibaAccountForm";

    private final SibaAccountFormRepository sibaAccountFormRepository;

    public SibaAccountFormResource(SibaAccountFormRepository sibaAccountFormRepository) {
        this.sibaAccountFormRepository = sibaAccountFormRepository;
    }

    /**
     * POST  /siba-account-forms : Create a new sibaAccountForm.
     *
     * @param sibaAccountForm the sibaAccountForm to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sibaAccountForm, or with status 400 (Bad Request) if the sibaAccountForm has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/siba-account-forms")
    public ResponseEntity<SibaAccountForm> createSibaAccountForm(@RequestBody SibaAccountForm sibaAccountForm) throws URISyntaxException {
        log.debug("REST request to save SibaAccountForm : {}", sibaAccountForm);
        if (sibaAccountForm.getId() != null) {
            throw new BadRequestAlertException("A new sibaAccountForm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SibaAccountForm result = sibaAccountFormRepository.save(sibaAccountForm);
        return ResponseEntity.created(new URI("/api/siba-account-forms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /siba-account-forms : Updates an existing sibaAccountForm.
     *
     * @param sibaAccountForm the sibaAccountForm to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sibaAccountForm,
     * or with status 400 (Bad Request) if the sibaAccountForm is not valid,
     * or with status 500 (Internal Server Error) if the sibaAccountForm couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/siba-account-forms")
    public ResponseEntity<SibaAccountForm> updateSibaAccountForm(@RequestBody SibaAccountForm sibaAccountForm) throws URISyntaxException {
        log.debug("REST request to update SibaAccountForm : {}", sibaAccountForm);
        if (sibaAccountForm.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SibaAccountForm result = sibaAccountFormRepository.save(sibaAccountForm);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sibaAccountForm.getId().toString()))
            .body(result);
    }

    /**
     * GET  /siba-account-forms : get all the sibaAccountForms.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sibaAccountForms in body
     */
    @GetMapping("/siba-account-forms")
    public List<SibaAccountForm> getAllSibaAccountForms() {
        log.debug("REST request to get all SibaAccountForms");
        return sibaAccountFormRepository.findAll();
    }

    /**
     * GET  /siba-account-forms/:id : get the "id" sibaAccountForm.
     *
     * @param id the id of the sibaAccountForm to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sibaAccountForm, or with status 404 (Not Found)
     */
    @GetMapping("/siba-account-forms/{id}")
    public ResponseEntity<SibaAccountForm> getSibaAccountForm(@PathVariable Long id) {
        log.debug("REST request to get SibaAccountForm : {}", id);
        Optional<SibaAccountForm> sibaAccountForm = sibaAccountFormRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sibaAccountForm);
    }

    /**
     * DELETE  /siba-account-forms/:id : delete the "id" sibaAccountForm.
     *
     * @param id the id of the sibaAccountForm to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/siba-account-forms/{id}")
    public ResponseEntity<Void> deleteSibaAccountForm(@PathVariable Long id) {
        log.debug("REST request to delete SibaAccountForm : {}", id);
        sibaAccountFormRepository.deleteById(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
