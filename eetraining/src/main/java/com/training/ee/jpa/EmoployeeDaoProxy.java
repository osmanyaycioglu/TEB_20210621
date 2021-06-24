package com.training.ee.jpa;

public class EmoployeeDaoProxy extends EmoployeeDao {

    private EmoployeeDao emoployeeDao;

    @Override
    public void add(final Employee employee) {
        // transaction begin
        try {
            this.emoployeeDao.add(employee);
            // transaction commit
        } catch (Exception eLoc) {
            // transaction rollback
        }
    }


}
