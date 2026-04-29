package com.dmx.social_graph.user.infrastructure.persistence;

import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchClientAdapter;
import com.dmx.infrastructure.persistence.elasticsearch.ElasticsearchRepository;
import com.dmx.shared.kernel.Service;
import com.dmx.social_graph.user.domain.UserDTO;
import com.dmx.social_graph.user.domain.UserMapper;
import com.dmx.social_graph.user.domain.UserRepository;

import java.util.Optional;

@Service
public class ElasticSearchUserRepository extends ElasticsearchRepository<UserDTO> implements UserRepository {
    public ElasticSearchUserRepository(ElasticsearchClientAdapter client) {
        super(client);
    }

    @Override
    protected String moduleName() {
        return "user";
    }

    @Override
    public void save(UserDTO user) {
        persist(user.id(), UserMapper.toPlainData(user));
    }

    @Override
    public Optional<UserDTO> find(String id) {
        return byId(id, UserMapper::toDTO);
    }

    @Override
    public boolean existsUser(String id) {
        return byId(id, UserMapper::toDTO).isPresent();
    }
}
