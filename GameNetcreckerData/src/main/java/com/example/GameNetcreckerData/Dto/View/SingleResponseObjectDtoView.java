package com.example.GameNetcreckerData.Dto.View;

public class SingleResponseObjectDtoView {

    public interface StatusCode {
    }

    public interface Message {
    }

    public interface Success {
    }

    public interface DataOrException {
    }

    public interface Full extends StatusCode, Message, Success, DataOrException {
    }
}
