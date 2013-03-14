package com.mtga.common.service.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mtga.common.service.ExpansionRepo;
import com.mtga.common.utils.Profiles;
import com.mtga.common.utils.Repos;

@Service
@Profile(Profiles.JPA)
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages=Repos.JPA_REPOS_PKG)
public class JpaExpansionRepo implements ExpansionRepo {

    @Override
    public byte[] getLogo(String abbr) {
        // TODO Auto-generated method stub
        return null;
    }

}
