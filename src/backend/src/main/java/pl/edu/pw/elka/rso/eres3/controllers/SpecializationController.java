package pl.edu.pw.elka.rso.eres3.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pw.elka.rso.eres3.controllers.abstractions.AbstractCrudController;
import pl.edu.pw.elka.rso.eres3.domain.entities.Specialization;
import pl.edu.pw.elka.rso.eres3.domain.repositories.SpecializationRepository;

/**
 * Rest controller for specializations.
 */
@RestController
@Transactional
public class SpecializationController extends AbstractCrudController<Specialization, Integer> {
	private static final String mapping = "/specializations";
	private final SpecializationRepository specializationRepo;

	@Autowired
	public SpecializationController(final SpecializationRepository specializationRepo) {
		super(specializationRepo, true);
		this.specializationRepo = specializationRepo;
	}

	@RequestMapping(value = "units/{id}/specializations", method = RequestMethod.GET)
	@PreAuthorize("hasPermission(#id, 'OrganizationalUnit', 'SpecializationRead')")
	public Iterable<Specialization> getAllSpecializationsOnUnit(@PathVariable final short id){
		return specializationRepo.findByUnitId(id);
	}

	@RequestMapping(value = mapping + "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasPermission(#id, 'Specialization', 'SpecializationRead')")
	public ResponseEntity<Specialization> getSpecialization(@PathVariable final int id){
		return getEntity(id);
	}

	@RequestMapping(value = mapping, method = RequestMethod.POST)
    @PreAuthorize("hasPermission(#specialization, 'SpecializationCreate')")
	public ResponseEntity<Specialization> addSpecialization(@RequestBody final Specialization specialization){
		return addEntity(specialization);
	}

	@RequestMapping(value = mapping, method = RequestMethod.PUT)
    @PreAuthorize("hasPermission(#specialization, 'SpecializationUpdate')")
	public ResponseEntity<Specialization> updateSpecialization(@RequestBody final Specialization specialization) {
		return updateEntity(specialization);
	}

	@RequestMapping(value = mapping + "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasPermission(#id, 'Specialization', 'SpecializationDelete')")
	public ResponseEntity<Specialization> deleteSpecialization(@PathVariable final int id) {
		return deleteEntity(id);
	}

	@Override
	protected String getControllerMapping() {
		return mapping;
	}
}