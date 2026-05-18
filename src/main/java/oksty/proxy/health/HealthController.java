package oksty.proxy.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class HealthController {

    @GetMapping("/isalive")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok("Alive");
    }

    @GetMapping("/isready")
    public ResponseEntity<String> isReady() {
        return ResponseEntity.ok("Ready");
    }
}
