/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Administrator
 */
public class CD {
    private int id;
    private String tilte;
    private String cate;
    private int _public;

    public CD() {
    }

    public CD(int id, String tilte, String cate, int _public) {
        this.id = id;
        this.tilte = tilte;
        this.cate = cate;
        this._public = _public;
    }

    public int getId() {
        return id;
    }

    public String getTilte() {
        return tilte;
    }

    public String getCate() {
        return cate;
    }

    public int getPublic() {
        return _public;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setPublic(int _public) {
        this._public = _public;
    }

   
   
    
}
