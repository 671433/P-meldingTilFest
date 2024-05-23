package com.hvl.no.Oblig4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hvl.no.Oblig4.model.Deltager;

@Repository
public interface DeltagerRepository extends JpaRepository<Deltager, Integer> {
	
	public Deltager findByMobil(String mobil);
	
	public List<Deltager> findAllByOrderByFornavnAscEtternavnAsc();
}
