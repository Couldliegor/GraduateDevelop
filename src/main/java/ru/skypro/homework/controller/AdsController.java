package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
@Tag(name = "Объявления", description = "API по работе с объявлениями")
public class AdsController {

    @Operation(summary = "Получить все объявления")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = ResponseWrapperAdsDto[].class))
            )
    )
    @GetMapping("/ads")
    public ResponseEntity<ResponseWrapperAdsDto> getAllAds() {
//todo:
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Добавить объявление")
    @ApiResponse(
            responseCode = "201",
            description = "Created",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AdsDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )
    @PostMapping(value = "/ads", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdsDto> addAd(@RequestPart CreateAdsDto properties, @RequestPart MultipartFile image) {
//todo:
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получить комментарии объявления")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = ResponseWrapperCommentDto[].class)))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @GetMapping("/ads/{id}/comments")
    public ResponseEntity<ResponseWrapperCommentDto> getComments(@PathVariable long id) {
        ResponseWrapperCommentDto comments = new ResponseWrapperCommentDto(); //todo: написать реализацию
        return ResponseEntity.ok().body(comments);
    }

    @Operation(summary = "Добавить комментарий к объявлению")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CommentDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )

    @PostMapping("/ads/{id}/comments")
    public ResponseEntity<CommentDto> addComment(@PathVariable Integer id, @RequestBody CommentDto commentDto) { //todo почему CommentDto а не просто Comment ?
        CommentDto newCommentDto = new CommentDto(); //todo написать реализацию
        return ResponseEntity.ok().body(newCommentDto);
    }

    @Operation(summary = "Получить информацию об объявлении")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = FullAdsDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @GetMapping("/ads/{id}")
    public ResponseEntity<FullAdsDto> getAd(@PathVariable Integer id) {
        FullAdsDto fullAdsDto = new FullAdsDto(); //todo: написать реализацию
        return ResponseEntity.ok(fullAdsDto);
    }

    @Operation(summary = "Удалить объявление")
    @ApiResponse(
            responseCode = "204",
            description = "No content"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )

    @DeleteMapping("/ads/{id}")
    public ResponseEntity<?> removeAd(@PathVariable int id) {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить информацию об объявлении")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AdsDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )

    @PatchMapping("/ads/{id}")
    public ResponseEntity<AdsDto> updateAds(@PathVariable Integer id, @RequestBody CreateAdsDto createAdsDto) {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Удалить комментарий")
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )
    @DeleteMapping("/ads/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment( @PathVariable Integer adId, @PathVariable Integer commentId) {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить комментарий")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CommentDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )
    @PatchMapping("/ads/{adsId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Integer adsId, @PathVariable Integer commentId) {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Получить объявления авторизованного пользователя")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ResponseWrapperAdsDto[].class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Unauthorized"
    )
    @ApiResponse(
            responseCode = "403",
            description = "Forbidden"
    )
    @GetMapping("/ads/me")
    public ResponseEntity<ResponseWrapperAdsDto> getAdsMe() {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить картинку объявления")
    @ApiResponse(
            responseCode = "200",
            description = "OK",
            content = @Content(
                    mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE
            ))
    @ApiResponse(
            responseCode = "404",
            description = "Not Found"
    )
    @PatchMapping(value = "/ads/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> updateImage(@PathVariable("id") Integer id, @RequestPart MultipartFile image) {
        //todo: написать реализацию
        return ResponseEntity.ok().build();
    }
}
