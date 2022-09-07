package security;

import com.google.common.collect.Sets;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static security.ApplicationPermission.*;

public enum applicationRole {
    student(Sets.newHashSet()),

    admin(Sets.newHashSet(COURSE_READ, STUDENT_READ, STUDENT_WRITE, COURSE_WRITE));
    private final Set<ApplicationPermission> permissionSet;

    applicationRole(Set<ApplicationPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationPermission> getPermissionSet() {
        return permissionSet;
    }
}
