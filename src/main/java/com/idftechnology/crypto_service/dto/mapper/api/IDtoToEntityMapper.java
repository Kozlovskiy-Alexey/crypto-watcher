package com.idftechnology.crypto_service.dto.mapper.api;

public interface IDtoToEntityMapper <E, D> {

    D entityToDto(E entity);

    E DtoToEntity(D dto);

}
