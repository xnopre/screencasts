package lib;

/**
 * Permet des opérations de commuication avec le gestionnaire de barrière
 */
public interface Connector {

    /**
     * Permet l'envoi de trame, par exemple "OGx" pour ouvrir la barrière 'x'
     * @param frame Trame à envoyer
     */
    void sendFrame(String frame);
}
