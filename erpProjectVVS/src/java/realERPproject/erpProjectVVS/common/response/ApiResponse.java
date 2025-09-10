package realERPproject.erpProjectVVS.common.response;

import lombok.Builder;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Builder
public record ApiResponse<T>(HttpStatus httpStatus,
                             int statusValue,
                             boolean success,
                             String message,
                             T data,
                             LocalDateTime timestamp) {

        public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message) {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    ApiResponse.<T>builder()
                            .httpStatus(HttpStatus.CREATED)
                            .statusValue(HttpStatus.CREATED.value())
                            .success(true)
                            .message(message)
                            .data(data)
                            .timestamp(LocalDateTime.now())
                            .build());
        }

        public static <T> ResponseEntity<ApiResponse<T>> update(T data, String message){

            return ResponseEntity.status(HttpStatus.FOUND).body(
                    ApiResponse.<T>builder()
                            .httpStatus(HttpStatus.FOUND)
                            .statusValue(HttpStatus.FOUND.value())
                            .success(true)
                            .message(message)
                            .data(data)
                            .timestamp(LocalDateTime.now())
                            .build());
        }

        public static <T> ResponseEntity<ApiResponse<T>> success(T data,String meassage){

            return ResponseEntity.ok(
                    ApiResponse.<T>builder()
                            .httpStatus(HttpStatus.OK)
                            .statusValue(HttpStatus.OK.value())
                            .success(true)
                            .message(meassage)
                            .data(data)
                            .timestamp(LocalDateTime.now())
                            .build()
            );

        }

    }
