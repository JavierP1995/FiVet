/*
 * MIT License
 *
 * Copyright (c) 2020 Javier Palacios Arce
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * implementacion de repository con ORMLite.
 * @param <T>  tipo de modelo.
 * @param <K> tipo de id.
 */
public class RepositoryOrmLite<T, K> implements Repository<T, K> {

  /**
   * dao generico.
   */
  private final Dao<T, K> theDao;

  /**
   * constructor.
   *
   * @param connectionSource conexion a ORM.
   * @param theClazz         to use as source.
   */
  public RepositoryOrmLite(ConnectionSource connectionSource, Class<T> theClazz) {
    try {
      theDao = DaoManager.createDao(connectionSource, theClazz);
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * @return List de T.
   */
  @Override
  public List<T> findAll() {
    try {
      return theDao.queryForAll();
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * @param id a buscar.
   * @return El t con el id indicado.
   */
  @Override
  public T findById(K id) {
    try {
      return theDao.queryForId(id);
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * @param t a guardar.
   * @return true.
   */
  @Override
  public boolean create(T t) {
    try {
      return theDao.create(t) == 1;
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * @param t a actualizar.
   * @return true.
   */
  @Override
  public boolean update(T t) {
    try {
      return theDao.update(t) == 1;
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }

  /**
   * @param id a borrar.
   * @return true.
   */
  @Override
  public boolean delete(K id) {
    try {
      return theDao.deleteById(id) == 1;
    } catch (SQLException throwables) {
      throw new RuntimeException(throwables);
    }
  }
}
