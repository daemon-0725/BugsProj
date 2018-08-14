package com.intern.bugs;

import java.util.List;

interface BugsService {
    BugsDTO create(BugsDTO bug);
    BugsDTO delete (String id);
    List<BugsDTO> findAll();
    BugsDTO findById(String id);
    BugsDTO update(BugsDTO bug);
}