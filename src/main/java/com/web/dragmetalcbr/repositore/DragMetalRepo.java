package com.web.dragmetalcbr.repositore;

import com.web.dragmetalcbr.model.DragMetalCB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragMetalRepo extends JpaRepository<DragMetalCB,Long> {
}
