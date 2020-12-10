package controller;

public class HandlerFactory {

    public RequestHandler getHandler(String handlerName) {
        RequestHandler handler = null;

        try {
            Class handlerClass = Class.forName("controller." + handlerName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            //handler.setModel(service);
        } catch (Exception e) {
            throw new RuntimeException("Pagina niet gevonden.");
        }

        return handler;
    }

}
