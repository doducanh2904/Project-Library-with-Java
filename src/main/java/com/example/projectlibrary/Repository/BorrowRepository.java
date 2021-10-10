package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Borow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borow, Long> {
    //    Tra cứu lịch sử đật sách
    @Query(value = "SELECT * FROM borrow WHERE borrow_id =?1 AND borrow_role= 2", nativeQuery = true)
    Borow findBorowByIdAndRole(Long borrowId );

    //    Không chấp nhận yêu cầu mượn sách
    @Transactional
    @Modifying
    @Query(value = "update borrow set borrow_role=2 where borrow_id =?1", nativeQuery = true)
    void updateAccept(Long borrowId);

    //    Chấp nhận yêu cầu mượn sách
    @Transactional
    @Modifying
    @Query(value = "update borrow set borrow_role=0 where borrow_id =?1", nativeQuery = true)
    void updateNotAccept(Long borrowId);

}
