package Demo_2_8_5;

import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {

    AuthorDto entityToDto(Author entity);

    Author dtoToEntity(AuthorDto dto);

}