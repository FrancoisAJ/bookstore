/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.repositories;

import com.ntech.bookstore.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RolesRepo extends CrudRepository<Role, Long> {
    Role findById(long id);
}
