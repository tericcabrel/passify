package com.tericcabrel.passify.repositories;

import com.tericcabrel.passify.models.NoteGroup;
import org.springframework.data.repository.CrudRepository;

public interface NoteGroupRepository extends CrudRepository<NoteGroup, Long> {
    public NoteGroup findByName(String name);
}
