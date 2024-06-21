package za.ac.cput.soccer.player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = ("All"))
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player){
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path = {"/{playerId}"})
    public void deletePlayer(@PathVariable("playerId") Long playerId){
        playerService.deletePlayer(playerId);
    }

    public void updatePlayer(
            @PathVariable("playerId") Long playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        playerService.updatePlayer(playerId, name, email);

    }

}
