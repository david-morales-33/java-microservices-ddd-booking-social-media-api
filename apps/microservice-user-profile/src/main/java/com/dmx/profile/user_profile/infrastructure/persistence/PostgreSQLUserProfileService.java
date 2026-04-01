package com.dmx.profile.user_profile.infrastructure.persistence;

import com.dmx.profile.status.domain.Status;
import com.dmx.profile.user_profile.domain.UserProfileService;
import com.dmx.shared.kernel.Service;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("profile-transaction_manager")
public class PostgreSQLUserProfileService implements UserProfileService {
    protected final SessionFactory sessionFactory;

    public PostgreSQLUserProfileService(@Qualifier("profile-session_factory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Status> findDefaultStatus() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Status s WHERE s.label.value = :label", Status.class)
                .setParameter("label", "AVAILABLE")
                .uniqueResultOptional();
    }

}
