package za.ac.cput.soccer.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    final private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository
                .findPlayerByEmail(player.getEmail());
        if(playerOptional.isPresent()) {
            throw new IllegalStateException("Player already exists");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("player with id " + playerId + "Player does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(Long playerId,
                             String name,
                             String email) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalStateException(
                "player with id " + playerId + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(player.getName(), name)) {
            player.setName(name);

        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(player.getEmail(), email)) {
            player.setEmail(email);
        }
        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(player.getEmail(), email)) {
            Optional<Player> playerOptional = playerRepository
                    .findPlayerByEmail(email);
            if(playerOptional.isPresent()) {
                throw new IllegalStateException("player with email " + email + " already exists");
            }
            player.setEmail(email);
        }
    }
}
