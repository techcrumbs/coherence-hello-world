package com.techcrunch.example.cachestores.transformer;

public interface  DtoEntryTransformer <DTO, ENTITY> {

  DTO toDtoFromEntity(ENTITY entity);

  ENTITY toEntityFromDto(DTO dto);

}
