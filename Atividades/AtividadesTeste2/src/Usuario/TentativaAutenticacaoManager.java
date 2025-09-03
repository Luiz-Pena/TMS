package Usuario;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TentativaAutenticacaoManager {
    private final List<Instant> tentativas = new ArrayList<>();
    private boolean bloqueado = false;
    private Instant desbloqueio;

    public void registrarTentativa() throws ExceededAttemptsException {
        Instant agora = Instant.now();

        if (bloqueado && agora.isBefore(desbloqueio)) {
            throw new ExceededAttemptsException("Autenticação bloqueada. Tente novamente após 1 minuto.");
        }

        tentativas.removeIf(t -> t.isBefore(agora.minusSeconds(30)));
        tentativas.add(agora);

        if (tentativas.size() >= 4) {
            bloqueado = true;
            desbloqueio = agora.plusSeconds(60);
            tentativas.clear();
            throw new ExceededAttemptsException("Excesso de tentativas em 30 segundos.");
        }
    }

    public void resetar() {
        tentativas.clear();
        bloqueado = false;
        desbloqueio = null;
    }
}

