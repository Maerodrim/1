package com.example.GameNetcreckerData.Dto;

import com.example.GameNetcreckerData.Dto.Status.StatusCodeEnum;
import com.example.GameNetcreckerData.Dto.Status.StatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.EnumMap;

@Log4j2
public abstract class SingleResponseObjectDto {

    @Getter(value = AccessLevel.PRIVATE)
    private final EnumMap<StatusEnum, StatusCodeEnum> errorCodeEnum =
            new EnumMap<>(StatusEnum.class);

    protected SingleResponseObjectDto() {

        errorCodeEnum.put(StatusEnum.AllDoneWell, StatusCodeEnum.StatusCode200);
        errorCodeEnum.put(StatusEnum.Unauthorized, StatusCodeEnum.StatusCode401);
        errorCodeEnum.put(StatusEnum.NoAccess, StatusCodeEnum.StatusCode403);
        errorCodeEnum.put(StatusEnum.AnyOtherShit, StatusCodeEnum.StatusCode666);

        log.info("Map in the SingleResponseObjectDto has completed");
    }

    protected StatusCodeEnum getErrorCodeEnum(StatusEnum statusEnum) {
        return this.errorCodeEnum.get(statusEnum);
    }
}