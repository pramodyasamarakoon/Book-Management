package com.airhacks.controller;

import com.airhacks.model.Book;
import com.airhacks.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path( "Book" )
public class BookController {

    @Inject
    private BookService bookService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllBooks(){
        return Response
                .ok( bookService.getAllBooks(), MediaType.APPLICATION_JSON )
                .build();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") Integer id ){
        if ( bookService.getBookById(id).isPresent() ){
            return Response
                    .ok( bookService.getBookById(id).get(), MediaType.APPLICATION_JSON )
                    .build();
        }
        return Response
                .status( Response.Status.NOT_FOUND )
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveBook( Book book ){
        Optional<Book> newBook = bookService.addNewBook( book );
        if ( newBook.isPresent() ){
            return Response
                    .ok( newBook, MediaType.APPLICATION_JSON )
                    .build();
        }
        return Response.status( Response.Status.BAD_REQUEST ).build();
    }

    @DELETE
    @Path( "{id}" )
    public Response deleteBookById( @PathParam("id") Integer id ){
        if ( bookService.removeBookById(id) ){
            return Response
                    .status( Response.Status.ACCEPTED )
                    .build();
        }
        return Response
                .status( Response.Status.NOT_FOUND )
                .build();
    }

    @PUT
    @Path( "{id}" )
    public Response updateFoodById( @PathParam("id") Integer id, Book book ){
        Optional<Book> newBook = bookService.updateBookById( id, book );
        if (newBook.isPresent() ){
            return Response
                    .status( Response.Status.ACCEPTED )
                    .build();
        }
        return Response
                .status( Response.Status.NOT_FOUND )
                .build();
    }


}
