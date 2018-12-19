package pl.training.bank.disposition;

import org.mapstruct.Mapper;

@Mapper
public interface DispositionMapper {

   Disposition map(DispositionTo dispositionTo);

}
