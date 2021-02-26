package spring.security.domain;

import lombok.*;
import spring.security.domain.common.BaseTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleHierarchy extends BaseTime implements Serializable {

    @Id @GeneratedValue
    @Column(name = "role_hierarchy_id")
    private Long id;

    private String authority;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent", referencedColumnName = "authority")
    private RoleHierarchy parent;

    private boolean deleted;

}