package ec.com.portfolio.sofkaU.api.repository;

import ec.com.portfolio.sofkaU.api.domain.collection.Portfolio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPortfolioRepository extends ReactiveMongoRepository<Portfolio, String> {
}
