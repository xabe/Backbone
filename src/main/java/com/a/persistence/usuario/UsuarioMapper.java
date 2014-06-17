package com.a.persistence.usuario;

import com.a.model.usuario.Usuario;
import com.a.model.usuario.UsuarioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.a.persistence.PersistenceBase;
public interface UsuarioMapper extends PersistenceBase<Usuario, UsuarioExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int countByExample(UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int deleteByExample(UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int insert(Usuario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int insertSelective(Usuario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    List<Usuario> selectByExample(UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    Usuario selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int updateByExampleSelective(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int updateByExample(@Param("record") Usuario record, @Param("example") UsuarioExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int updateByPrimaryKeySelective(Usuario record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_usuario
     *
     * @mbggenerated Tue Jun 17 08:17:26 CEST 2014
     */
    int updateByPrimaryKey(Usuario record);
}