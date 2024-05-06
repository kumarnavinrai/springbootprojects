package com.pieropan.springdatamanytomany.mapper;

import com.pieropan.springdatamanytomany.dto.EmpresaComFuncionarioResponse;
import com.pieropan.springdatamanytomany.dto.EmpresaResponse;
import com.pieropan.springdatamanytomany.entity.Empresa;
import com.pieropan.springdatamanytomany.entity.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-05T15:47:47+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public List<EmpresaResponse> listEmpresaResponse(List<Empresa> empresas) {
        if ( empresas == null ) {
            return null;
        }

        List<EmpresaResponse> list = new ArrayList<EmpresaResponse>( empresas.size() );
        for ( Empresa empresa : empresas ) {
            list.add( empresaToEmpresaResponse( empresa ) );
        }

        return list;
    }

    @Override
    public List<EmpresaComFuncionarioResponse> listEmpresaComFuncionarioResponse(List<Empresa> empresas) {
        if ( empresas == null ) {
            return null;
        }

        List<EmpresaComFuncionarioResponse> list = new ArrayList<EmpresaComFuncionarioResponse>( empresas.size() );
        for ( Empresa empresa : empresas ) {
            list.add( empresaToEmpresaComFuncionarioResponse( empresa ) );
        }

        return list;
    }

    protected EmpresaResponse empresaToEmpresaResponse(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaResponse empresaResponse = new EmpresaResponse();

        empresaResponse.setId( empresa.getId() );
        empresaResponse.setNome( empresa.getNome() );
        empresaResponse.setCnpj( empresa.getCnpj() );

        return empresaResponse;
    }

    protected EmpresaComFuncionarioResponse empresaToEmpresaComFuncionarioResponse(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaComFuncionarioResponse empresaComFuncionarioResponse = new EmpresaComFuncionarioResponse();

        empresaComFuncionarioResponse.setId( empresa.getId() );
        empresaComFuncionarioResponse.setNome( empresa.getNome() );
        empresaComFuncionarioResponse.setCnpj( empresa.getCnpj() );
        List<Funcionario> list = empresa.getFuncionarios();
        if ( list != null ) {
            empresaComFuncionarioResponse.setFuncionarios( new ArrayList<Funcionario>( list ) );
        }

        return empresaComFuncionarioResponse;
    }
}
