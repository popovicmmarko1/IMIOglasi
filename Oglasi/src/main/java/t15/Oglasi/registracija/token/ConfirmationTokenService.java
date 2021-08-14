package t15.Oglasi.registracija.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Getter
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token)
    {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token)
    {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token)
    {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
