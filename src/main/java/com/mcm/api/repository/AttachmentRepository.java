package com.mcm.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcm.api.entity.Attachment;

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, String> {

	List<Attachment> findByCaseid(String caseid);

	List<Attachment> findAllByCaseid(String caseid);

}
