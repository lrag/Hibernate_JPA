package com.curso.modelo.entidad;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFactura is a Querydsl query type for Factura
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFactura extends EntityPathBase<Factura> {

    private static final long serialVersionUID = -1960947798;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFactura factura = new QFactura("factura");

    public final QCliente cliente;

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Double> total = createNumber("total", Double.class);

    public QFactura(String variable) {
        this(Factura.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QFactura(Path<? extends Factura> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFactura(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFactura(PathMetadata<?> metadata, PathInits inits) {
        this(Factura.class, metadata, inits);
    }

    public QFactura(Class<? extends Factura> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cliente = inits.isInitialized("cliente") ? new QCliente(forProperty("cliente")) : null;
    }

}

