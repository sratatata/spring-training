package pl.training.bank.common;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ResultPageTransferObject<T> {

    @NonNull
    private List<T> data;
    private int pageNumber;
    private int totalPages;

}
